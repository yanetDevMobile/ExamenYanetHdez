package com.example.examenyanethdez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.examenyanethdez.databinding.FragmentSpinnerBinding

class SpinnerFragment: Fragment() {
    private  var _binding: FragmentSpinnerBinding? = null
    private val binding: FragmentSpinnerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpinnerBinding.inflate(inflater, container, false)

        val categories = resources.getStringArray(R.array.categorias)
        val arrayAdapter =ArrayAdapter(requireContext(), R.layout.item_aplicaciones, categories)
        binding.autoCompleteTextView.apply {
            setAdapter(arrayAdapter)
            
            doOnTextChanged { selectedCategrie, _, _, _ ->
                Toast.makeText(requireContext(), "Categoria seleccionada", Toast.LENGTH_LONG).show()
            }
        }
    return binding.root

    }
}