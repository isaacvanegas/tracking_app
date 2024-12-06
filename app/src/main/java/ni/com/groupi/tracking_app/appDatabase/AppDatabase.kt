package ni.gob.manera.seguimiento_proyecto.appDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.com.groupi.tracking_app.DAO.UserDAO
import ni.com.groupi.tracking_app.entity.User

@Database (
    entities = [User::class],
    views = [],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDAO

    companion object {

        @Volatile //evita que se guarde cache en memoria
        private var Instance : AppDatabase?  = null

                fun getDatabase(context: Context): AppDatabase {

                    return Instance ?: synchronized (this){ //synchronized -> garantiza que se la base de datos solo se inicialice una vez
                        Room.databaseBuilder(context,AppDatabase::class.java,"tracking_database")
                            .fallbackToDestructiveMigration() // destruye los datos en la bd cuando no se tiene espesificado un objeto de migracion al cambiar las entidades
                            .build()
                            .also { Instance = it }  //genera la intacia de la base de datos
                    }
                }

    }

}