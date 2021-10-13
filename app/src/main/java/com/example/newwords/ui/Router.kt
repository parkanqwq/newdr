package com.example.newwords.ui

import android.app.Activity
import com.example.newwords.domain.PersonEntity

interface Router {
    fun openMainScreen(activity: Activity, personModel: PersonEntity?)
}