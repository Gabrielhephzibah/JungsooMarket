package com.cherish.jungsoomarketapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.cherish.jungsoomarketapp.model.StoreData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface StoreDao {
    @Query("SELECT * FROM  StoreData ORDER BY id DESC")
    fun getAllStoreItem(): Flowable<List<StoreData>>

    @Query("SELECT * FROM StoreData WHERE myId LIKE :itemId")
    fun getSingleItem(itemId: Int): Single<StoreData>

    @Insert
    fun addStoreItem(storeItem: StoreData) : Completable


}