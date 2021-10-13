package com.example.newwords.impl

import android.view.View
import com.example.newwords.domain.PersonEntity
import com.example.newwords.domain.PersonRepo
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.*

class PersonRepoImpl: PersonRepo{
    private val behaviorSubject = BehaviorSubject.create<PersonEntity>()
    private val btnChange = BehaviorSubject.create<View>()

    override fun add(person: PersonEntity) {
        behaviorSubject.onNext(person)
    }

    override val btn: Observable<View>
        get() = btnChange

    override val person: Observable<PersonEntity>
        get() = behaviorSubject

}