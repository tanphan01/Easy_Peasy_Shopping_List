package be.bf.android.myfirstshoppinglist.db.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.bf.android.myfirstshoppinglist.db.DbHelper

class ProductViewModelFactory(val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(DbHelper.instance(context).products(), DbHelper.instance(context).listProducts()) as T
    }
}
