package be.bf.android.myfirstshoppinglist.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.adapters.CategoryAdapter
import be.bf.android.myfirstshoppinglist.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSecondFragment.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvSecondFragment.layoutManager = GridLayoutManager(context, 2)
        binding.rvSecondFragment.adapter = CategoryAdapter() {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }

//        binding.pets.setOnClickListener(this)
//        val toast = Toast.makeText(context, "Pets", Toast.LENGTH_SHORT)
//        toast.show()
//        binding.skincare.setOnClickListener(this)
//        val toast2 = Toast.makeText(context, "Skincare", Toast.LENGTH_SHORT)
//        toast2.show()
//        binding.baby.setOnClickListener(this)
//        val toast3 = Toast.makeText(context, "Babycare", Toast.LENGTH_SHORT)
//        toast3.show()
//        binding.frozen.setOnClickListener(this)
//        val toast4 = Toast.makeText(context, "Frozen Foods", Toast.LENGTH_SHORT)
//        toast4.show()
//        binding.household.setOnClickListener(this)
//        val toast5 = Toast.makeText(context, "Household", Toast.LENGTH_SHORT)
//        toast5.show()
//        binding.healthcare.setOnClickListener(this)
//        val toast6 = Toast.makeText(context, "Healthcare", Toast.LENGTH_SHORT)
//        toast6.show()
//        binding.bread.setOnClickListener(this)
//        val toast7 = Toast.makeText(context, "Bakery & Bread", Toast.LENGTH_SHORT)
//        toast7.show()
//        binding.condiments.setOnClickListener(this)
//        val toast8 = Toast.makeText(context, "Oils, Sauces & Condiments", Toast.LENGTH_SHORT)
//        toast8.show()
//        binding.drinks.setOnClickListener(this)
//        val toast9 = Toast.makeText(context, "Drinks", Toast.LENGTH_SHORT)
//        toast9.show()
//        binding.milk.setOnClickListener(this)
//        val toast10 = Toast.makeText(context, "Dairy, Cheese & Eggs", Toast.LENGTH_SHORT)
//        toast10.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment,)
    }

//    override fun onClick(v: View?) {
//
//        Toast.makeText(context, "Target : " + v?.id, Toast.LENGTH_SHORT).show()
//        findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment,)
//    }
}