package be.bf.android.myfirstshoppinglist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.adapters.UpdateListAdapter
import be.bf.android.myfirstshoppinglist.databinding.FragmentThirdBinding
import be.bf.android.myfirstshoppinglist.entities.Product
import be.bf.android.myfirstshoppinglist.enums.CategoryProductEnum

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvThirdFragment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvThirdFragment.adapter = UpdateListAdapter(mutableListOf())


        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_FourFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

