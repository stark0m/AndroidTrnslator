package geekbrains.ru.translator.model.repository

import com.example.androidtrnslator.domain.dtomodel.DataModel
import com.example.androidtrnslator.model.datasource.DataSource

import io.reactivex.Observable



class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
