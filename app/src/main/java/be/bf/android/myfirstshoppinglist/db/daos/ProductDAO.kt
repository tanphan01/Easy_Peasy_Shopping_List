package be.bf.android.myfirstshoppinglist.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import be.bf.android.myfirstshoppinglist.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(product: Product): Long

    @Query("SELECT * FROM products")
    fun findAll() : List<Product>
}