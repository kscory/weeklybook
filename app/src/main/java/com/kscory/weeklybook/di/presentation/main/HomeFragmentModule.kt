package com.kscory.weeklybook.di.presentation.main

import androidx.lifecycle.ViewModel
import com.kscory.weeklybook.di.presentation.viewmodel.ViewModelKey
import com.kscory.weeklybook.presentation.home.HomeFragment
import com.kscory.weeklybook.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}