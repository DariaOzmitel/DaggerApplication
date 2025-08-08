package com.example.feature_home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.feature_home.databinding.FragmentHomeBinding
import com.example.feature_home.di.HomeComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HomeComponent.init(requireContext()).inject(this)
        binding.button.setOnClickListener {
            viewModel.getCardList1()
        }
        binding.button2.setOnClickListener {
            viewModel.getCardList2()
        }
        lifecycleScope.launch {
            viewModel.mainState.collect { cardListIdsCount ->
                binding.textView.text = cardListIdsCount.toString()
            }
        }
    }
}