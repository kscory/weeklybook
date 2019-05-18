package com.kscory.weeklybook.presentation

import androidx.annotation.IdRes
import com.kscory.weeklybook.R

enum class PageConfiguration(
    val id: Int,
    val hasTitle: Boolean = true,
    val hasMenu: Boolean = false,
    val isShowLogoImage: Boolean = false,
    val hideToolbar: Boolean = false
) {
    HOME(R.id.home, hasMenu = true, isShowLogoImage = true),
//    DETAIL(R.id.session_detail, hasTitle = false, hideToolbar = true),
//    SPEAKER(R.id.speaker, hasTitle = false),
//    SURVEY(R.id.session_survey, hasTitle = false),
    OTHER(0);

    operator fun component1() = id
    operator fun component2() = hasMenu
    operator fun component3() = hasTitle
    operator fun component4() = isShowLogoImage

    companion object {
        fun getConfiguration(@IdRes id: Int): PageConfiguration {
            return PageConfiguration
                .values()
                .firstOrNull { it.id == id } ?: OTHER
        }
    }
}