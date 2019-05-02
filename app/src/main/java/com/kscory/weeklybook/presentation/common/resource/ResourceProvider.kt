package com.kscory.weeklybook.presentation.common.resource

import android.content.Context
import android.util.TypedValue
import androidx.annotation.DimenRes
import androidx.annotation.StringRes

interface ResourceProvider {
    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: String): String
    fun dimen(@DimenRes id: Int): Float
    fun getDp(dps: Float): Int
}

class ResourceProviderImpl(context: Context): ResourceProvider {
    private val resources = context.resources

    override fun string(id: Int): String = resources.getString(id)

    override fun string(id: Int, vararg args: String): String = resources.getString(id, args)

    override fun dimen(id: Int): Float = resources.getDimension(id)

    override fun getDp(dps: Float): Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, resources.displayMetrics).toInt()

}