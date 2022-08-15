package be.bf.android.myfirstshoppinglist.db.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.bf.android.myfirstshoppinglist.db.RoomScope
import be.bf.android.myfirstshoppinglist.db.daos.ProductDAO
import be.bf.android.myfirstshoppinglist.db.entities.Product
import kotlinx.coroutines.launch

class ProductViewModel(val dao: ProductDAO): ViewModel() {
    private val products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>>
        get() = products

    init {
        val vm = this
        RoomScope().launch {
            dao.findAll().collect { vm.changeProducts(it) }
        }
    }

    private fun changeProducts(Products: List<Product>) {
        this.products.value = Products
    }
}
