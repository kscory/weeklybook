package com.kscory.weeklybook.presentation.home.viewusecase

import com.kscory.weeklybook.R
import com.kscory.weeklybook.presentation.home.HomeFragment

interface ChangeFavoriteViewUseCase {

    fun changeFavorite(isFavorite: Boolean)
}

class ChangeFavoriteViewViewUseCaseImpl(private val fragment: HomeFragment) : ChangeFavoriteViewUseCase {

    override fun changeFavorite(isFavorite: Boolean) {
        val menu = fragment.menu ?: return

        if (isFavorite) {
            menu
                .getItem(0)
                .setIcon(R.drawable.ic_star_black_24dp)
        } else {
            menu
                .getItem(0)
                .setIcon(R.drawable.ic_star_border_black_24dp)
        }
    }
}