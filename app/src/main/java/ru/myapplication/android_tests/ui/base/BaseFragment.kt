package ru.myapplication.android_tests.ui.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import ru.myapplication.android_tests.ui.RootActivity

abstract class BaseFragment : Fragment() {

    val root : RootActivity
        get() = activity as RootActivity

    open val prepareToolbar: (ToolbarBuilder.() -> Unit)? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //prepare toolbar
        root.toolbarBuilder
            .invalidate()
            .prepare(prepareToolbar)
            .build(root)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        if (root.toolbarBuilder.items.isNotEmpty()) {
            for ((index, menuHolder) in root.toolbarBuilder.items.withIndex()) {
                val item = menu.add(0, menuHolder.menuId, index, menuHolder.title)
                item.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS or MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
                    .setIcon(menuHolder.icon)
                    .setOnMenuItemClickListener {
                        menuHolder.clickListener?.invoke(it)?.let { true } ?: false
                    }
                menuHolder.actionViewLayout?.let { item.setActionView(it) }

            }
        } else menu.clear()
        super.onPrepareOptionsMenu(menu)
    }

}