package ru.myapplication.android_tests.ui

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_root.*
import ru.myapplication.android_tests.R
import ru.myapplication.android_tests.ui.base.BaseActivity

class RootActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        setSupportActionBar(toolbar)
        navigate(Navigation.FragmentATab)
        prepareUI()
    }

    private fun prepareUI() {
        nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> navigate(Navigation.FragmentATab)
                R.id.nav_android -> navigate(Navigation.FragmentBTab)
            }
            true
        }
    }

    fun navigate(navigation: Navigation) {
        when (navigation) {
            is Navigation.FragmentATab -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .replace(R.id.fragment_container, FragmentA())
                    .commit()
            }

            is Navigation.FragmentBTab -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .replace(R.id.fragment_container, FragmentB())
                    .commit()
            }

            is Navigation.FragmentA -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .addToBackStack(null)
                    .add(R.id.fragment_container, FragmentA())
                    .commit()
            }

            is Navigation.FragmentB -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .addToBackStack(null)
                    .add(R.id.fragment_container, FragmentB())
                    .commit()
            }

            is Navigation.FragmentC -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .addToBackStack(null)
                    .add(R.id.fragment_container, FragmentC())
                    .commit()
            }

            is Navigation.FragmentD -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .addToBackStack(null)
                    .add(R.id.fragment_container, FragmentD())
                    .commit()
            }

            is Navigation.FragmentE -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .addToBackStack(null)
                    .add(R.id.fragment_container, FragmentE())
                    .commit()
            }

            is Navigation.FragmentF -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_right,
                        R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left,
                        R.anim.slide_out_to_right)
                    .addToBackStack(null)
                    .add(R.id.fragment_container, FragmentF())
                    .commit()
            }

            is Navigation.Back -> {
                supportFragmentManager
                    .popBackStack()
            }
        }
    }

    sealed class Navigation {
        object FragmentATab : Navigation()
        object FragmentBTab : Navigation()
        object FragmentA : Navigation()
        object FragmentB : Navigation()
        object FragmentC : Navigation()
        object FragmentD : Navigation()
        object FragmentE : Navigation()
        object FragmentF : Navigation()
        object Back : Navigation()
    }
}