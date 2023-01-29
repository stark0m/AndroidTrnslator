package com.example.androidtrnslator.di

import com.example.androidtrnslator.domain.dtomodel.DataModel
import com.example.androidtrnslator.model.datasource.DataSource
import com.example.androidtrnslator.model.datasource.DataSourceRemote
import com.example.androidtrnslator.model.interactor.MainInteractor
import geekbrains.ru.translator.model.repository.Repository
import geekbrains.ru.translator.model.repository.RepositoryImplementation
import geekbrains.ru.translator.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val  appModules  = module {

    single<DataSource<List<DataModel>>> { DataSourceRemote() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(get()) }
    single<SchedulerProvider> {  SchedulerProvider() }
    single<CompositeDisposable> {CompositeDisposable()}
    single<MainInteractor> { MainInteractor( get()) }

}