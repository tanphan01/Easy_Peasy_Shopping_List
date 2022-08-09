package be.bf.android.myfirstshoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

        binding.pets.setOnClickListener(this)
        binding.skincare.setOnClickListener(this)
        binding.baby.setOnClickListener(this)
        binding.frozen.setOnClickListener(this)
        binding.household.setOnClickListener(this)
        binding.healthcare.setOnClickListener(this)
        binding.bread.setOnClickListener(this)
        binding.condiments.setOnClickListener(this)
        binding.drinks.setOnClickListener(this)
        binding.milk.setOnClickListener(this)

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