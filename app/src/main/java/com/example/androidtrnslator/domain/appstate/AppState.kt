package com.example.androidtrnslator.domain.appstate

import com.example.androidtrnslator.domain.dtomodel.DataModel

sealed class AppState {

    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
