package com.example.androidtrnslator.model.presenter


import com.example.androidtrnslator.domain.appstate.AppState
import geekbrains.ru.translator.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)


}
