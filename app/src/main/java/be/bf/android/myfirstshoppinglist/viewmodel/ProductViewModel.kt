package be.bf.android.myfirstshoppinglist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bf.android.myfirstshoppinglist.db.daos.ListProductDAO
import be.bf.android.myfirstshoppinglist.db.daos.ProductDAO
import be.bf.android.myfirstshoppinglist.db.entities.ListProduct
import be.bf.android.myfirstshoppinglist.db.entities.Product
import kotlinx.coroutines.launch

class ProductViewModel(val productDAO: ProductDAO, val listProductDAO: ListProductDAO): ViewModel() {

    private val _allListProduct : MutableLiveData<List<ListProduct>> = MutableLiveData()
    val allListProduct : LiveData<List<ListProduct>>
        get() = _allListProduct

    private val _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>>
        get() = _products

    private val _listProduct : MutableLiveData<ListProduct?> = MutableLiveData()
    val listProduct: LiveData<ListProduct?>
        get() = _listProduct

    private var _listSelected : MutableLiveData<Long?> = MutableLiveData()
    val listSelected : LiveData<Long?>
        get() = _listSelected

    init {
        val vm = this
        vm.changeProducts(listOf())
        viewModelScope.launch {
            listProductDAO.findAll().collect() {
                Log.d("ListProduct vm", it.toString())
                vm.changeAllListProduct(it)
            }
        }
    }

    private fun changeProducts(Products: List<Product>) {
        this._products.value = Products
    }

    private fun changeAllListProduct(allListProduct: List<ListProduct>) {
        this._allListProduct.value = allListProduct
    }

    private fun changeListProduct(listProduct: ListProduct) {
        this._listProduct.value = listProduct
    }

    fun changeListSelected(id : Long) {
        _listSelected.value = id
        loadListProduct()
        loadProduct()
    }

    private fun loadListProduct() {
        val vm = this
        viewModelScope.launch {
            _listSelected.value?.let { it ->
                listProductDAO.findOneById(it).collect() {
                    vm.changeListProduct(it)
                }
            }
        }
    }

    private fun loadProduct() {
        val vm = this
        viewModelScope.launch {
            _listSelected.value?.let { it ->
                productDAO.findByListProductId(it).collect {
                    vm.changeProducts(it)
                }
            }
        }
    }

    fun clearData() {
        _products.value = listOf()
        _listProduct.value = null
        _listSelected.value = null
    }

    fun delete(listProduct: ListProduct?) {
        Log.d("ProductViewModel", "delete: "+ listProduct)
        if (listProduct != null) {
            listProductDAO.deleteListProduct(listProduct)
        }
    }
}
