

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtrnslator.domain.appstate.AppState
import com.example.androidtrnslator.model.presenter.Presenter
import geekbrains.ru.translator.view.base.View


abstract class BaseActivity<T : AppState> : AppCompatActivity(), View {

    abstract override fun renderData(appState: AppState)

}
