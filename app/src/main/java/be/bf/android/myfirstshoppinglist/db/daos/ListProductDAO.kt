package be.bf.android.myfirstshoppinglist.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import be.bf.android.myfirstshoppinglist.entities.ListProduct

@Dao
interface ListProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(listProduct: ListProduct) : Long

    @Query("SELECT * FROM list_products")
    fun findAll() : List<ListProduct>
}