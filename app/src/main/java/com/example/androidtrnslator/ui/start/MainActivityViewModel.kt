package com.example.androidtrnslator.ui.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtrnslator.domain.appstate.AppState
import com.example.androidtrnslator.model.datasource.DataSourceRemote
import com.example.androidtrnslator.model.interactor.MainInteractor
import com.example.androidtrnslator.model.vievmodels.MainActivityVievModelContract
import geekbrains.ru.translator.model.repository.RepositoryImplementation
import geekbrains.ru.translator.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class MainActivityViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote())
    ),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel(), MainActivityVievModelContract {
    private var vmLiveData: MutableLiveData<AppState> = MutableLiveData()

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { vmLiveData.postValue(AppState.Loading(null)) }
                .subscribeWith(getLocalObserver())
        )
    }

    fun getObserver(): MutableLiveData<AppState> {
        return vmLiveData
    }

    private fun getLocalObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                vmLiveData.postValue(appState)
            }

            override fun onError(e: Throwable) {
                vmLiveData.postValue(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}