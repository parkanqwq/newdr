package com.example.newwords.impl.util

import android.content.Context
import com.example.newwords.App

val Context.app: App
    get() {
        return applicationContext as App
    }