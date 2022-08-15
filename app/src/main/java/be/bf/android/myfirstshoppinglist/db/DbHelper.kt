package be.bf.android.myfirstshoppinglist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.bf.android.myfirstshoppinglist.db.daos.ListProductDAO
import be.bf.android.myfirstshoppinglist.db.daos.ProductDAO
import be.bf.android.myfirstshoppinglist.db.entities.ListProduct
import be.bf.android.myfirstshoppinglist.db.entities.Product

@Database(entities = [Product::class, ListProduct::class], version = 1, exportSchema = false)
abstract class DbHelper : RoomDatabase() {
    abstract fun products(): ProductDAO
    abstract fun listProducts() : ListProductDAO

    companion object {
        const val DB_NAME = "room_database"
        private var instance : DbHelper? = null
        fun instance(context: Context): DbHelper {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(context, DbHelper::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}