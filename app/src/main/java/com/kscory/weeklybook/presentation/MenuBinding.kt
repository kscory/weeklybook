package com.kscory.weeklybook.presentation

import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

interface IMenuCallbackListener {
    fun onPrepareOptionsMenu(menu: Menu)
    fun onOptionsItemSelected(menuItemId: Int)
}

class MenuBinding(activity: AppCompatActivity): IMenuCallbackListener {

    override fun onPrepareOptionsMenu(menu: Menu) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onOptionsItemSelected(menuItemId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}