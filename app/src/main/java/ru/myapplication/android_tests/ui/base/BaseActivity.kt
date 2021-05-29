package ru.myapplication.android_tests.ui.base

import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_root.*

abstract class BaseActivity : AppCompatActivity() {



    val toolbarBuilder = ToolbarBuilder()

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }

}

class ToolbarBuilder {
    var title: String? = null
    var subtitle: String? = null
    var visibility: Boolean = true
    val items: MutableList<MenuItemHolder> = mutableListOf()

    fun setTitle(title: String) : ToolbarBuilder {
        this.title = title
        return this
    }

    fun setSubtitle(subtitle: String) : ToolbarBuilder {
        this.subtitle = subtitle
        return this
    }

    fun setVisibility(isVisible: Boolean) : ToolbarBuilder {
        this.visibility = isVisible
        return this
    }

    fun addMenuItem(item: MenuItemHolder) : ToolbarBuilder {
        this.items.add(item)
        return this
    }

    fun invalidate() : ToolbarBuilder {
        this.title = null
        this.subtitle = null
        this.visibility = true
        this.items.clear()
        return this
    }

    fun prepare(prepareFn: (ToolbarBuilder.() -> Unit)? ) : ToolbarBuilder {
        invalidate()
        prepareFn?.invoke(this)
        return this
    }

    fun build(context: FragmentActivity) {
        if (this.title != null) context.toolbar.title = this.title
        if (this.subtitle != null) context.toolbar.subtitle = this.subtitle
        context.toolbar.visibility = if (this.visibility) View.VISIBLE else View.GONE
    }

}

data class MenuItemHolder(
    val title: String,
    val menuId: Int,
    val icon: Int,
    val actionViewLayout: Int? = null,
    val clickListener: ((MenuItem) -> Unit)? = null
)