package com.example.androidtrnslator.model.interactor

import com.anikin.aleksandr.simplevocabulary.viewmodel.Interactor
import com.example.androidtrnslator.domain.appstate.AppState
import com.example.androidtrnslator.domain.dtomodel.DataModel
import geekbrains.ru.translator.model.repository.Repository
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            TODO()// что то выдать локальное
        }
    }
}

