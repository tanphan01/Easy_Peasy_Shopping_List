package be.bf.android.myfirstshoppinglist.db.daos

import androidx.room.*
import be.bf.android.myfirstshoppinglist.db.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(product: Product): Long

    @Update
    fun updateProducts(vararg products: Product)

    @Delete
    fun deleteProducts(vararg products: Product)

    @Query("SELECT * FROM products")
    fun findAll() : Flow<List<Product>>

    @Query("SELECT * FROM products WHERE listProductId = :id")
    fun findByListProductId(id : Long) : Flow<List<Product>>

    @Query("SELECT * FROM products WHERE id = :id")
    fun findOneById(id: Long): Flow<Product>

}