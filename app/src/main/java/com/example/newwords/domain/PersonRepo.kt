package com.example.newwords.domain

import android.view.View
import io.reactivex.Observable

interface PersonRepo {
    fun add(person: PersonEntity)
    val btn: Observable<View>
    val person: Observable<PersonEntity>
}