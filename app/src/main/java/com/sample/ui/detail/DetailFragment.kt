package com.sample.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sample.R
import com.sample.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        setupUi()
    }

    private fun setupUi() {
        Glide.with(requireContext())
            .load(arguments?.getString(argIcon))
            .placeholder(R.drawable.avatar_1)
            .into(binding.imageView)

        binding.label.text = arguments?.getString(argTitle)
        binding.definition.text = arguments?.getString(argDescription)
    }

    companion object {
        val argIcon = "Icon"
        val argTitle = "Title"
        val argDescription = "Description"
    }
}