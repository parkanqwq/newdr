package com.example.newwords

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.example.newwords.impl.RouterImpl
import com.example.newwords.ui.Router

// самодельный класс cicerone
//class App : Application() {
//    val router: Router = RouterImpl()
//}

class App : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
}