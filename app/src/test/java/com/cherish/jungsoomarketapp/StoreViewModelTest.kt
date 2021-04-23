package com.cherish.jungsoomarketapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.cherish.jungsoomarketapp.data.db.StoreDao
import com.cherish.jungsoomarketapp.data.db.StoreDataBase
import com.cherish.jungsoomarketapp.model.StoreData
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.cherish.jungsoomarketapp.viewmodel.StoreViewModel
import org.junit.Rule
import org.mockito.Mockito.*
import java.util.*
import kotlin.collections.ArrayList


@RunWith(MockitoJUnitRunner::class)
class StoreViewModelTest {
    @get:Rule
    var executorRule = InstantTaskExecutorRule()

   lateinit var  storeViewModel : StoreViewModel

    @Before
    fun setUp(){
        val context = mock(Application::class.java)
        storeViewModel = StoreViewModel(context)

    }

    @Test
    fun getSelectedValueTest(){
        storeViewModel.setSelectedValue("3")
        assertEquals("3", storeViewModel.getSelectedValue().value )
    }

    @Test
        fun selectedItemTest(){
        val storeData = StoreData(0,"id","http://www.example.org","https://images.unsplash.com/photo-1519996529931-28324d5a630e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80", "Potatoes","4500")
        storeViewModel.setSelectedItem(storeData)
        assertEquals(storeData, storeViewModel.getSelectedItem().value)

        }







}