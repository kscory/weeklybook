package com.kscory.weeklybook.presentation

import android.os.Bundle
import com.kscory.weeklybook.R
import com.kscory.weeklybook.presentation.common.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController.navigateToHome()
        setupBottomNavigation(savedInstanceState)

    }

    private fun setupBottomNavigation(savedInstanceState: Bundle?) {
        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navigationController.navigateToHome()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    navigationController.navigateToFavorite()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {

                }
            }
            false
        }
    }


}
