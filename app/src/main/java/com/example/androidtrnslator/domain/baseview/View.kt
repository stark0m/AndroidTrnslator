package geekbrains.ru.translator.view.base

import com.example.androidtrnslator.domain.appstate.AppState


interface View {

    fun renderData(appState: AppState)

}
