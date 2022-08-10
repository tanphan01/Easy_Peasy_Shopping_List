package be.bf.android.myfirstshoppinglist.entities

import be.bf.android.myfirstshoppinglist.enums.CategoryProductEnum

data class Product(
    val name : String,
    val quantity : Int,
    val category : CategoryProductEnum,
)
