package be.bf.android.myfirstshoppinglist.db.daos

import androidx.room.*
import be.bf.android.myfirstshoppinglist.db.entities.ListProduct
import be.bf.android.myfirstshoppinglist.db.entities.Product
import kotlinx.coroutines.flow.Flow

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

    @Query("SELECT * FROM LIST_PRODUCTS")
    fun findAll() : Flow<List<ListProduct>>

    @Query("SELECT * FROM LIST_PRODUCTS WHERE id = :id")
    fun findOneById(id: Long): Flow<ListProduct>

}