package com.sample.ui.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.slidingpanelayout.widget.SlidingPaneLayout.LOCK_MODE_LOCKED
import com.sample.R
import com.sample.data.networking.Resource
import com.sample.databinding.FragmentListBinding
import com.sample.ui.SlidingPaneBackManager
import com.sample.ui.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var backManager: SlidingPaneBackManager
    private lateinit var binding: FragmentListBinding
    private var adapter: ListItemAdapter? = null
    private val listViewModel: ListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        backManager = SlidingPaneBackManager(binding.slidingPaneLayout)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backManager)
        setupUI()
        observeData()
    }

    private fun observeData() {
        listViewModel.getCharacters().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progress.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    binding.progress.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.progress.visibility = View.GONE
                    binding.rvList.visibility = View.VISIBLE
                    result.data?.let { adapter?.setData(it) }
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun setupUI() {
        val navHost = childFragmentManager.findFragmentById(R.id.detail_container) as NavHostFragment
        val controller = navHost.navController
        binding.slidingPaneLayout.lockMode = LOCK_MODE_LOCKED
        binding.rvList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = ListItemAdapter {
            controller.navigate(
                R.id.detailFragment, bundleOf(
                    DetailFragment.argTitle to it.name,
                    DetailFragment.argDescription to it.description,
                    DetailFragment.argIcon to it.icon
                )
            )
            binding.root.open()
        }
        binding.rvList.adapter = adapter
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter?.filter?.filter(newText)
                return true
            }
        })

    }

}