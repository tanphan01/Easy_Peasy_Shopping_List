package be.bf.android.myfirstshoppinglist.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_products")
data class ListProduct constructor(
    @PrimaryKey(autoGenerate = true)
    val id : Long? = null,
    val name : String,
    val categoriesList : String,

)
