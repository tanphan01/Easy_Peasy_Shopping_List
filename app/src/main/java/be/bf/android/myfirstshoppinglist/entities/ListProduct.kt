package be.bf.android.myfirstshoppinglist.entities

import android.nfc.Tag

data class ListProduct(
    val name : String,
    val categories_list : String,
    val tag: Tag,
)
