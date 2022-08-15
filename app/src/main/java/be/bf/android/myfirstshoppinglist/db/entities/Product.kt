package be.bf.android.myfirstshoppinglist.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import be.bf.android.myfirstshoppinglist.enums.CategoryProductEnum

@Entity(tableName = "products")
data class Product constructor(
    @PrimaryKey(autoGenerate = true)
    var id : Long? = null,
    val name : String,
    val quantity : Int = 1,
    val category : CategoryProductEnum = CategoryProductEnum.PETS,
    var listProductId : Long? = null
)
