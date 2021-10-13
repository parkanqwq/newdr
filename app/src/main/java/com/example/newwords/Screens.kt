package com.example.newwords

import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.example.newwords.domain.PersonModel
import com.example.newwords.ui.main.MainActivity

object Screens {
    fun Main(personModel: PersonModel?) = ActivityScreen {
            context -> MainActivity.createLauncherIntent(context, personModel)
    }
}