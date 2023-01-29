//package com.example.androidtrnslator.ui.start
//
//
//import com.example.androidtrnslator.domain.appstate.AppState
//import com.example.androidtrnslator.model.datasource.DataSourceRemote
//import com.example.androidtrnslator.model.interactor.MainInteractor
//import com.example.androidtrnslator.model.presenter.Presenter
//import geekbrains.ru.translator.model.repository.RepositoryImplementation
//import geekbrains.ru.translator.rx.SchedulerProvider
//import geekbrains.ru.translator.view.base.View
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.observers.DisposableObserver
//
//class MainPresenterImpl<T : AppState, V : View>(
//    private val interactor: MainInteractor = MainInteractor(
//        RepositoryImplementation(DataSourceRemote())
//    ),
//    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
//    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
//) : Presenter<T, V> {
//
//    private var currentView: V? = null
//
//
//
//
//    override fun getData(word: String, isOnline: Boolean) {
//        compositeDisposable.add(
//            interactor.getData(word, isOnline)
//                .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
//                .subscribeWith(getObserver())
//        )
//    }
//
//    private fun getObserver(): DisposableObserver<AppState> {
//        return object : DisposableObserver<AppState>() {
//
//            override fun onNext(appState: AppState) {
//                currentView?.renderData(appState)
//            }
//
//            override fun onError(e: Throwable) {
//                currentView?.renderData(AppState.Error(e))
//            }
//
//            override fun onComplete() {
//            }
//        }
//    }
//}
