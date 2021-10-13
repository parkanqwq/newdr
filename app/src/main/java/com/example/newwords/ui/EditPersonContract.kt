package com.example.newwords.ui

import com.example.newwords.domain.PersonEntity
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle

class EditPersonContract {

    enum class ViewState {
        LOADING, SUCCESS, ERROR, DEFEAT
    }

    interface View : MvpView {
        @AddToEnd
        fun setState(state: ViewState)
        @AddToEnd
        fun setPerson(personModel: PersonEntity)
        @AddToEndSingle
        fun setAgeError(errorCode: Int)
        // самодельный класс cicerone
//        @Skip
//        fun exit()
//        @Skip
//        fun openMainScreen(personModel: PersonModel?)
    }

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun onFight(personModel: PersonEntity)
        abstract fun onCheckFight(personModel: PersonEntity)
        abstract fun onResultFight(resultFight: Int, personModel: PersonEntity)
        abstract fun onLimitedString(personModel: PersonEntity) : Boolean
    }
}