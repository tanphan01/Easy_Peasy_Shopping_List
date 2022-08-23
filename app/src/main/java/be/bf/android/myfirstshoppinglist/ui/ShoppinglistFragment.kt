package be.bf.android.myfirstshoppinglist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.adapters.CategoryAdapter
import be.bf.android.myfirstshoppinglist.databinding.FragmentShoppinglistBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ShoppinglistFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentShoppinglistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShoppinglistBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvShoppinglistFragment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvShoppinglistFragment.layoutManager = GridLayoutManager(context, 2)
        binding.rvShoppinglistFragment.adapter = CategoryAdapter() {
            findNavController().navigate(R.id.action_ShoppinglistFragment_to_ThirdFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        findNavController().navigate(R.id.action_ShoppinglistFragment_to_ThirdFragment,)
    }

}