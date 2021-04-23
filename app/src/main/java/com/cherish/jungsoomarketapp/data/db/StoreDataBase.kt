package com.cherish.jungsoomarketapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cherish.jungsoomarketapp.model.StoreData

@Database(entities = [StoreData::class], version = 1,exportSchema = false)
abstract class StoreDataBase : RoomDatabase() {
    abstract fun storeDao(): StoreDao
    companion object {
        @Volatile
        private var myInstance: StoreDataBase? = null
        fun getDatabaseInstance(mContext: Context): StoreDataBase =
            myInstance ?: synchronized(this) {
                myInstance ?: buildDatabaseInstance(mContext).also {
                    myInstance = it
                }
            }

        private fun buildDatabaseInstance(mContext: Context) =
            Room.inMemoryDatabaseBuilder(mContext, StoreDataBase::class.java).build()
    }

}