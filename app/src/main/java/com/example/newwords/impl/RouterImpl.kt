package com.example.newwords.impl

import android.app.Activity
import com.example.newwords.domain.PersonEntity
import com.example.newwords.ui.Router
import com.example.newwords.ui.main.MainActivity

class RouterImpl : Router {
    // для самописного cicerone
    override fun openMainScreen(activity: Activity, personModel: PersonEntity?) {
        activity.startActivity(MainActivity.createLauncherIntent(activity, personModel))
    }
}