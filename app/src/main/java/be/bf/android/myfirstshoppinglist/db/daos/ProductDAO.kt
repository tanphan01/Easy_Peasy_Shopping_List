package be.bf.android.myfirstshoppinglist.db.daos

import androidx.room.*
import be.bf.android.myfirstshoppinglist.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(product: Product): Long

    @Update
    fun updateProducts(vararg products: Product)

    @Delete
    fun deleteProducts(vararg products: Product)

    @Query("DELETE FROM products")
    fun deleteAll()

    @Query("SELECT * FROM products")
    fun findAll() : List<Product>
}