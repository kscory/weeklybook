package com.kscory.weeklybook.di.presentation.main

import androidx.lifecycle.ViewModel
import com.kscory.weeklybook.di.presentation.viewmodel.ViewModelKey
import com.kscory.weeklybook.presentation.home.HomeFragment
import com.kscory.weeklybook.presentation.home.HomeViewModel
import com.kscory.weeklybook.presentation.home.viewusecase.ChangeFavoriteViewUseCase
import com.kscory.weeklybook.presentation.home.viewusecase.ChangeFavoriteViewViewUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [HomeFragmentModule.Binders::class])
class HomeFragmentModule {

    @Module
    interface Binders {
        @Binds
        @IntoMap
        @ViewModelKey(HomeViewModel::class)
        abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
    }

    @Provides
    fun providesChangeFavoriteUseCase(fragment: HomeFragment): ChangeFavoriteViewUseCase = ChangeFavoriteViewViewUseCaseImpl(fragment)
}