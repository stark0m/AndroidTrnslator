package com.example.androidtrnslator.model.datasource

import com.example.androidtrnslator.domain.dtomodel.DataModel
import com.example.androidtrnslator.model.repository.RetrofitImplementation
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
