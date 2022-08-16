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
import be.bf.android.myfirstshoppinglist.databinding.FragmentFourBinding
import be.bf.android.myfirstshoppinglist.db.viewmodel.ProductViewModel
import be.bf.android.myfirstshoppinglist.db.viewmodel.ProductViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FourFragment : Fragment() {


    private var _binding: FragmentFourBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel : ProductViewModel by activityViewModels { ProductViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFourBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.products.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvFragmentFour.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

                Log.d("List de produit : ", it.toString())
            }
        }

        viewModel.listProduct.observe(viewLifecycleOwner) {
            if (it != null) {
                Log.d("List-produit : ", it.toString())
            }
        }

        binding.fab2.setOnClickListener {
            Snackbar.make(view, "Add more categories ?", Snackbar.LENGTH_SHORT)
                .setAction("Cancel", View.OnClickListener {
                }).show()

            findNavController().navigate(R.id.action_FourFragment_to_ThirdFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}