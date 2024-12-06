package ni.gob.manera.seguimiento_proyecto.dataStore
import android.content.Context
import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class SettingsDataStore (context: Context) {
    private val settings = "settings"
//    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = settings)
//
//    private val islogged = booleanPreferencesKey("islogged")
//
//    private val urlBase = stringPreferencesKey("url_base")
//
//    suspend fun saveIsloggedStore(isLogged: Boolean, context: Context) {
//        context.dataStore.edit { preferences ->
//            preferences[islogged] = isLogged
//        }
//    }
//
//    suspend fun saveUrlBase(UrlBase: String, context: Context) {
//        context.dataStore.edit { preferences ->
//            preferences[urlBase] = UrlBase
//        }
//    }
//
//    val isloggedFlow: Flow<Boolean> = context.dataStore.data
//        .handleErrors()
//        .map { preferences ->
//            preferences[islogged] ?: false
//        }
//
//    val getUrlBaseFlow: Flow<String> = context.dataStore.data
//        .handleErrors()
//        .map { preferences ->
//            preferences[urlBase] ?: ""
//        }
//
//    /**
//     * manejador de exeption al leer la información.
//     */
//    private fun <T>  Flow<T>.handleErrors():Flow<T>{
//        return catch { exception ->
//            if(exception is IOException){
//                exception.printStackTrace()
//                emit(emptyPreferences() as T)
//            }else{
//                throw exception
//            }
//
//        }
//    }

}