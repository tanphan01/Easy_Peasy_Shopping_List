package be.bf.android.myfirstshoppinglist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.adapters.ListProductAdapter
import be.bf.android.myfirstshoppinglist.databinding.FragmentEditorlistBinding
import be.bf.android.myfirstshoppinglist.db.entities.ListProduct
import be.bf.android.myfirstshoppinglist.viewmodel.ProductViewModel
import be.bf.android.myfirstshoppinglist.viewmodel.ProductViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class EditorlistFragment : Fragment() {


    private var listOfLists: List<ListProduct> = mutableListOf()
    private var _binding: FragmentEditorlistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel : ProductViewModel by activityViewModels { ProductViewModelFactory(requireContext()) }

    private lateinit var adapter : ListProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditorlistBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListProductAdapter(listOf()) {
            Log.d("position clicked", it.toString())
            viewModel.changeListSelected(it)
            findNavController().navigate(R.id.action_EditorlistFragment_to_ShoppingdetailFragment)
        }

        binding.rvFragmentEditorlist.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvFragmentEditorlist.adapter = adapter

        viewModel.products.observe(viewLifecycleOwner) {
            if (it != null) {
                Log.d("List de produit : ", it.toString())
            }
        }

        viewModel.allListProduct.observe(viewLifecycleOwner) {
            Log.d("EditorlistFragment", "onViewCreated: "+ it)
            if (it != null) {
                adapter.clear()
                adapter.addData(it)
                this.listOfLists = it
                Log.d("List-produit : ", it.toString())
            }
        }

        binding.fab2.setOnClickListener {
            Snackbar.make(view, "Add more categories ?", Snackbar.LENGTH_SHORT)
                .setAction("Cancel", View.OnClickListener {
                }).show()

            viewModel.clearData()

            findNavController().navigate(R.id.action_EditorlistFragment_to_ShoppingdetailFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}