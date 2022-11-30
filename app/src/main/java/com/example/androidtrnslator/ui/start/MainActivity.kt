package com.example.androidtrnslator.ui.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidtrnslator.R
import com.example.androidtrnslator.domain.appstate.AppState
import com.example.androidtrnslator.model.presenter.Presenter
import geekbrains.ru.translator.view.base.BaseActivity
import geekbrains.ru.translator.view.base.View

class MainActivity : BaseActivity<AppState>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createPresenter(): Presenter<AppState, View> {
        TODO("Not yet implemented")
    }

    override fun renderData(appState: AppState) {
        TODO("Not yet implemented")
    }
}