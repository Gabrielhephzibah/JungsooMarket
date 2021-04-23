package com.cherish.jungsoomarketapp.model

import java.io.Serializable

class ShoppingData (val name : String?,
                    val price : Int?,
                    var id: Int = 0) : Serializable {


    override fun toString(): String {
        return "ShoppingData(name=$name, price=$price, id=$id)"
    }
}