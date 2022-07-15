package com.example.booklyapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booklyapp.R
import com.example.booklyapp.databinding.FragmentBooklyMainBinding
import com.example.booklyapp.presentation.adapter.bestSellers.BestSellersAdapter
import com.example.booklyapp.presentation.adapter.carousel.CarouselAdapter
import com.example.booklyapp.utils.Constants.BUNDLE_KEY
import com.example.booklyapp.utils.Constants.POP_BACK_STACK
import com.example.booklyapp.utils.SliderTransformer

class MainScreen : Fragment() {

    private lateinit var binding: FragmentBooklyMainBinding

    private lateinit var carouselAdapter: CarouselAdapter

    private lateinit var bestSellersAdapter: BestSellersAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooklyMainBinding.inflate(inflater, container, false)
        initViewPager()
        initRecyclerView()
        initViewModel()

        return binding.root
    }

    private fun initViewPager() {
        carouselAdapter = CarouselAdapter()
        binding.viewPager.apply {
            adapter = carouselAdapter
            offscreenPageLimit = 3
            setPageTransformer(SliderTransformer(3))
        }
    }

    private fun initRecyclerView() {
        bestSellersAdapter = BestSellersAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bestSellersAdapter
        }
        setupClickListener()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.bestSellersLiveData.observe(viewLifecycleOwner) { bestBooks ->
            bestSellersAdapter.list = bestBooks
        }
        viewModel.carouselSellersLiveData.observe(viewLifecycleOwner) { carouselBooks ->
            carouselAdapter.list = carouselBooks
        }
    }

    private fun setupClickListener() {
        bestSellersAdapter.clickOnBook = { item ->
            val detailScreen = DetailScreen()
            val bundle = Bundle().apply { putParcelable(BUNDLE_KEY, item) }
            detailScreen.arguments = bundle
            launchFragment(detailScreen)
        }
    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .addToBackStack(POP_BACK_STACK)
            .replace(R.id.container, fragment)
            .commit()
    }

}