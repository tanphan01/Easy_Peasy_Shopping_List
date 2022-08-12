package be.bf.android.myfirstshoppinglist.db.daos

import androidx.room.*
import be.bf.android.myfirstshoppinglist.entities.ListProduct
import be.bf.android.myfirstshoppinglist.entities.Product

@Dao
interface ListProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(listProduct: ListProduct) : Long

    @Update
    fun updateListProduct(vararg products: Product)

    @Delete
    fun deleteListProduct(vararg products: Product)

    @Query("DELETE FROM products")
    fun deleteAll()

    @Query("SELECT * FROM list_products")
    fun findAll() : List<ListProduct>
}