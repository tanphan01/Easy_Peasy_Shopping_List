package be.bf.android.myfirstshoppinglist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.adapters.UpdateListAdapter
import be.bf.android.myfirstshoppinglist.databinding.FragmentThirdBinding
import be.bf.android.myfirstshoppinglist.db.DbHelper
import be.bf.android.myfirstshoppinglist.db.daos.ListProductDAO
import be.bf.android.myfirstshoppinglist.db.daos.ProductDAO
import be.bf.android.myfirstshoppinglist.entities.ListProduct
import be.bf.android.myfirstshoppinglist.entities.Product
import be.bf.android.myfirstshoppinglist.enums.CategoryProductEnum
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var listProduct : ListProduct

    private val data : MutableList<Product> = mutableListOf()

    private lateinit var databaseProduct : ProductDAO
    private lateinit var databaseListProduct: ListProductDAO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseProduct = DbHelper.instance(requireContext()).products()
        databaseListProduct = DbHelper.instance(requireContext()).listProducts()

        binding.rvThirdFragment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvThirdFragment.adapter = UpdateListAdapter(data) { clickType, prout ->
            onItemClick(clickType, prout)
        }

        binding.btnCreate.setOnClickListener {

            val idListProduct = databaseListProduct.create(
                ListProduct(
                name = "Shopping List",
                categoriesList = "Daily"
            ))

            data.forEach {
                it.listProductId = idListProduct
                databaseProduct.create(it)
            }

            Log.d("List product :", databaseListProduct.findAll().toString())
            Log.d("Products", databaseProduct.findAll().toString())

            findNavController().navigate(R.id.action_ThirdFragment_to_FourFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }

    }

    private fun onItemClick(clickType: UpdateListAdapter.ClickType, produit: Product) {
        when(clickType) {
            UpdateListAdapter.ClickType.MINUS -> {
                data.remove(produit)
                binding.rvThirdFragment.adapter = UpdateListAdapter(data) { clickType, produit ->
                    onItemClick(clickType, produit)
                }
            }
            UpdateListAdapter.ClickType.PLUS -> {
                data.add(produit)
                binding.rvThirdFragment.adapter = UpdateListAdapter(data) { clickType, produit ->
                    onItemClick(clickType, produit)
                }
            }
        }
        Log.d("data", data.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

