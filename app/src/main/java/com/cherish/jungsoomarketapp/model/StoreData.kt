package com.cherish.jungsoomarketapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
class StoreData (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "myId") var itemId : String,
    @ColumnInfo(name = "qrUrl") var qrUrl : String,
    @ColumnInfo(name = "thumbnail") var thumbnail : String?,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "price") var price: String?) : Serializable {

    override fun toString(): String {
        return "StoreData(id=$id, itemId='$itemId', qrUrl='$qrUrl', thumbnail=$thumbnail, name=$name, price=$price)"
    }
}