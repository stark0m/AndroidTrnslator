package com.example.androidtrnslator.ui

import android.app.Application
import com.example.androidtrnslator.di.appModules
import com.example.androidtrnslator.model.datasource.DataSourceRemote
import com.example.androidtrnslator.model.interactor.MainInteractor
import geekbrains.ru.translator.model.repository.RepositoryImplementation
import geekbrains.ru.translator.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    val schedulerProvider: SchedulerProvider by inject()
    val compositeDisposable: CompositeDisposable by inject()
    val interactor: MainInteractor by inject()

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }
    }
}