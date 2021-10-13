package com.example.newwords.impl

import android.app.Activity
import android.content.Intent
import com.example.newwords.domain.PersonModel
import com.example.newwords.ui.Router
import com.example.newwords.ui.main.MainActivity

class RouterImpl : Router {
    // для самописного cicerone
    override fun openMainScreen(activity: Activity, personModel: PersonModel?) {
        activity.startActivity(MainActivity.createLauncherIntent(activity, personModel))
    }
}