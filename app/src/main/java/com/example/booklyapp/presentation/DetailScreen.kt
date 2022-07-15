package com.example.booklyapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.size.Scale
import com.example.booklyapp.R
import com.example.booklyapp.databinding.FragmentDetailScreenBinding
import com.example.booklyapp.domain.models.BestSellers
import com.example.booklyapp.presentation.adapter.similar.SimilarBooksAdapter
import com.example.booklyapp.utils.Constants.BUNDLE_KEY
import com.example.booklyapp.utils.Constants.POP_BACK_STACK

class DetailScreen : Fragment() {

    private lateinit var similarBooksAdapter: SimilarBooksAdapter

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: FragmentDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)

        setIBookInfo()

        initViewModel()

        initRecyclerView()

        binding.closeImageView.setOnClickListener { closeFragment() }

        return binding.root
    }

    private fun closeFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, MainScreen())
            .commit()
        parentFragmentManager.popBackStack(POP_BACK_STACK, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.similarBooks()
        viewModel.similarBooksLiveData.observe(viewLifecycleOwner) { books ->
            similarBooksAdapter.list = books
        }
    }

    private fun initRecyclerView() {
        similarBooksAdapter = SimilarBooksAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = similarBooksAdapter
        }
    }

    private fun setIBookInfo() {
        val book = arguments?.getParcelable<BestSellers>(BUNDLE_KEY)!!
        with(binding) {
            authorName.text = book.author
            bookName.text = book.title
            rateAmount.text = "(${book.rate.amount})"
            rateScoreText.text = book.rate.score.toString()
            imageView.load(book.image) {
                scale(Scale.FILL)
            }
        }
    }

}