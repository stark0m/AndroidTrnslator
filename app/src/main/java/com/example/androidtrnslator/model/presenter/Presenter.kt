package com.example.androidtrnslator.model.presenter

import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
