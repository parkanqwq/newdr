package com.example.newwords.ui

import android.os.Handler
import android.os.Looper
import com.github.terrakok.cicerone.Router
import com.example.newwords.Screens
import com.example.newwords.domain.PersonEntity
import com.example.newwords.server.PersonDB

class EditPersonPresenter(
    private val personsGames: PersonDB,
    private val router: Router
    ) : EditPersonContract.Presenter() {

    override fun onFight(personModel: PersonEntity) {
        viewState.setState(EditPersonContract.ViewState.LOADING)
        Handler(Looper.getMainLooper()).postDelayed(
            {onCheckFight(personModel)}, ONE_SECOND)
    }

    override fun onCheckFight(personModel: PersonEntity) {
        var bestPower = IM_WIN
        for (botBestPower in personsGames.getAllPerson()) {
            if (botBestPower.power >= personModel.power) bestPower = BOT_WIN
        }
        onResultFight(bestPower, personModel)
    }

    override fun onResultFight(resultFight: Int, personModel: PersonEntity) {
        if (resultFight == IM_WIN) {
            viewState.setState(EditPersonContract.ViewState.SUCCESS)
        // для самописного cicerone
//            viewState.openMainScreen(personModel)
//            viewState.exit()
            router.navigateTo(Screens.Main(personModel))
            router.exit()
        }
        else viewState.setState(EditPersonContract.ViewState.DEFEAT)
    }

    override fun onLimitedString(personModel: PersonEntity): Boolean {
        if (personModel.name.length > LENGTH_STRING || personModel.age > LENGTH_AGE || personModel.power > LENGTH_POWER) {
            viewState.setState(EditPersonContract.ViewState.ERROR)
            return false
        }
        return true
    }

    companion object {
        const val IM_WIN = 0
        const val BOT_WIN = 1
        const val LENGTH_STRING = 10
        const val LENGTH_AGE = 1000
        const val LENGTH_POWER = 100
        const val ONE_SECOND = 1000L
    }
}