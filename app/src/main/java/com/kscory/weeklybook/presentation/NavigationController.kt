package com.kscory.weeklybook.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kscory.weeklybook.R
import com.kscory.weeklybook.presentation.common.fragment.Findable
import com.kscory.weeklybook.presentation.main.favorite.FavoriteFragment
import com.kscory.weeklybook.presentation.main.home.HomeFragment
import com.kscory.weeklybook.presentation.signin.SignInActivity
import javax.inject.Inject

class NavigationController @Inject constructor(private val activity: AppCompatActivity) {
    private val containerId: Int = R.id.fl_content
    private val fragmentManager: FragmentManager = activity.supportFragmentManager

    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager
            .beginTransaction()
            .replace(containerId, fragment, (fragment as? Findable)?.tagForFinding)

        if (fragmentManager.isStateSaved) {
            transaction.commitAllowingStateLoss()
        } else {
            transaction.commit()
        }
    }

    fun navigateToHome() {
        replaceFragment(HomeFragment.newInstance())
    }

    fun navigateToFavorite() {
        replaceFragment(FavoriteFragment.newInstance())
    }

    fun navigateToSignInActivity() {
        SignInActivity.start(activity)
    }
}