package com.cherish.jungsoomarketapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cherish.jungsoomarketapp.data.db.StoreDataBase
import com.cherish.jungsoomarketapp.model.ShoppingData
import com.cherish.jungsoomarketapp.model.StoreData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class StoreViewModel(application: Application) : AndroidViewModel(application) {
    private val selectedValue = MutableLiveData<String>()
    private val itemValue = MutableLiveData<StoreData>()
    private val shoppingData = MutableLiveData<MutableList<StoreData>>(mutableListOf())
    val shopping = shoppingData as LiveData<MutableList<StoreData>>
    private var totalAmount = MutableLiveData<Int>()
    private fun fetchFromDatabase() = mutableListOf<StoreData>()

    init {
        val databaseSourcedItems = fetchFromDatabase()
        shoppingData.value = databaseSourcedItems
    }


    fun setSelectedValue(value : String){
        selectedValue.value = value
    }

    fun getSelectedValue(): MutableLiveData<String>{
        return  selectedValue
    }

    fun setSelectedItem(item : StoreData){
       itemValue.value = item
    }

    fun getSelectedItem() : MutableLiveData<StoreData>{
        return itemValue
    }

    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }

    fun <T> MutableLiveData<T>.notifyListObserver() {
        this.value = this.value

    }

    fun addShoppingData(){
        var item = itemValue.value
        shoppingData.value?.add(item!!)
        shoppingData.notifyObserver()
        calculatePrice()

    }

    fun calculatePrice(): MutableLiveData<Int> {
        totalAmount.value = 0
        val value = shopping.value

        if (value != null) {
            for (i in value) {
                totalAmount.value = totalAmount.value!! + i.price!!.toInt()

            }
        }

        return totalAmount
    }

    fun removeShopItem(recyclerList: ShoppingData) {
        val item: StoreData ? = shoppingData.value?.find { it.id == recyclerList.id }
        item?.let {
            shoppingData.value?.remove(it)
        }
        shoppingData.notifyListObserver()
        calculatePrice()
    }

    fun getTotalPrice() :  MutableLiveData<Int>{
        return totalAmount
    }

    private var databaeInstance = StoreDataBase.getDatabaseInstance(application)
    protected val compositeDisposable = CompositeDisposable()


    fun addStoreData(items: StoreData) {
        compositeDisposable.add(
            databaeInstance.storeDao()
                .addStoreItem(items)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {

                })
        )
    }

    fun getSingleItem(id: Int) {
        compositeDisposable.add(
            databaeInstance.storeDao()
                .getSingleItem(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    setSelectedItem(it)

                }, {

                })

        )
    }





}