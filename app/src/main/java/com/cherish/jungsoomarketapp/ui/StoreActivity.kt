package com.cherish.jungsoomarketapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.cherish.jungsoomarketapp.R
import com.cherish.jungsoomarketapp.model.StoreData
import com.cherish.jungsoomarketapp.viewmodel.StoreViewModel

class StoreActivity : AppCompatActivity() {
    private var storeViewModel: StoreViewModel? = null
    private val SPLASH_TIME_OUT : Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        storeViewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        var item1 = StoreData(0, "1", "http://www.example.org","https://images.unsplash.com/photo-1519996529931-28324d5a630e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80","Fruit Basket", "4300")
        var item2 = StoreData(0,"2","http://www.example.org","https://images.unsplash.com/photo-1518977676601-b53f82aba655?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Potatoes","430")
        var item3 = StoreData(0,"3","http://www.example.org","https://images.unsplash.com/photo-1543218024-57a70143c369?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"," Bananas", "340")
        var item4 = StoreData(0,"4","http://www.example.org","https://images.unsplash.com/photo-1587583650088-9451513b7b5d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80","Pineapple","870")
        var item5 = StoreData(0,"5","http://www.example.org","https://images.unsplash.com/photo-1447175008436-054170c2e979?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDR8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Carrot","5700")
        var item6 = StoreData(0,"6","http://www.example.org","https://images.unsplash.com/photo-1611048661702-7b55eed346b4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTV8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Cucumber","97")
        var item7 = StoreData(0,"7","http://www.example.org","https://images.unsplash.com/photo-1444731961956-751ed90465a5?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTl8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Tomatoes","24")
        var item8 = StoreData(0,"8","http://www.example.org","https://images.unsplash.com/photo-1553536645-f83758b55d23?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Vegetables","140")
        var item9= StoreData(0,"9","http://www.example.org","https://images.unsplash.com/photo-1513530774447-73de85f43d60?ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODV8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Pepper","350")
        var item10 = StoreData(0,"10","http://www.example.org","https://images.unsplash.com/photo-1540148426945-6cf22a6b2383?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTYyfHx2ZWdldGFibGVzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60","Garlic","6700")



        storeViewModel!!.addStoreData(item1)
        storeViewModel!!.addStoreData(item2)
        storeViewModel!!.addStoreData(item3)
        storeViewModel!!.addStoreData(item4)
        storeViewModel!!.addStoreData(item5)
        storeViewModel!!.addStoreData(item6)
        storeViewModel!!.addStoreData(item7)
        storeViewModel!!.addStoreData(item8)
        storeViewModel!!.addStoreData(item8)
        storeViewModel!!.addStoreData(item9)
        storeViewModel!!.addStoreData(item10)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)

    }
}
