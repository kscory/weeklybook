package com.kscory.weeklybook.di.presentation.main

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.kscory.weeklybook.presentation.main.MainActivity
import com.kscory.weeklybook.presentation.main.StartFromMainActivity
import com.kscory.weeklybook.presentation.main.favorite.FavoriteFragment
import com.kscory.weeklybook.presentation.main.home.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module(includes = [
    MainActivityModule.Binders::class
])
class MainActivityModule {

    @Module
    interface Binders {

        @Binds
        fun provideAppCompatActivity(mainActivity: MainActivity): AppCompatActivity

        @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
        fun contributeHomeFragment(): HomeFragment

        @ContributesAndroidInjector
        fun contributeFavoriteFragment(): FavoriteFragment
    }

    @Provides
    @Named("mainContext")
    fun provideMainContext(activity: MainActivity): Context = activity

    @Provides
    fun provideInflater(@Named("mainContext") context: Context) : LayoutInflater = LayoutInflater.from(context)

    @Provides
    fun providesStartToActivity(activity: MainActivity): StartFromMainActivity = activity
}