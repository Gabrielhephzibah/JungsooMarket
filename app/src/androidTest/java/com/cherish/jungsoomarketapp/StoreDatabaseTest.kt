package com.cherish.jungsoomarketapp

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cherish.jungsoomarketapp.data.db.StoreDao
import com.cherish.jungsoomarketapp.data.db.StoreDataBase
import com.cherish.jungsoomarketapp.model.StoreData
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class StoreDatabaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var storeDao: StoreDao
    private lateinit var storeDataBase: StoreDataBase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        storeDataBase = Room.inMemoryDatabaseBuilder(
            context, StoreDataBase::class.java).build()
        storeDao = storeDataBase.storeDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        storeDataBase.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetData() {
        val store = StoreData(0,"2","www.w.com","https://images.unsplash.com/photo-1519996529931-28324d5a630e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80","Tom","340")
        storeDao.addStoreItem(store).blockingAwait()
        storeDao.getAllStoreItem().test().assertValue { list ->
            list.isNotEmpty()
        }

    }






}