package ru.myapplication.android_tests.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_d.*
import ru.myapplication.android_tests.R
import ru.myapplication.android_tests.ui.base.BaseFragment
import ru.myapplication.android_tests.ui.base.MenuItemHolder
import ru.myapplication.android_tests.ui.base.ToolbarBuilder

class FragmentD : BaseFragment() {

    override val prepareToolbar: (ToolbarBuilder.() -> Unit)? = {
        setTitle("FragmentD")
        this.addMenuItem(MenuItemHolder(
            "close",
            R.id.nav_close,
            R.drawable.ic_baseline_close_24,
            clickListener = { menuItem ->
                root.navigate(RootActivity.Navigation.Back)
            }
        ))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_next.setOnClickListener {
            root.navigate(RootActivity.Navigation.FragmentE)
        }
    }
}