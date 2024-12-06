package ni.com.groupi.tracking_app.DAO

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDAO<T> {
    @Insert(onConflict =  OnConflictStrategy.ABORT )
    fun insert(vararg obj: T)
    @Update(onConflict =  OnConflictStrategy.ABORT )
    fun update(vararg obj: T)
    @Delete
    fun delete(vararg obj: T)
}