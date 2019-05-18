package com.kscory.weeklybook.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kscory.weeklybook.R
import com.kscory.weeklybook.databinding.FragmentHomeBinding
import com.kscory.weeklybook.presentation.common.fragment.Findable
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment(), Findable {
    override val tagForFinding: String
        get() = "home"
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    var menu: Menu? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewModel = homeViewModel
            lifecycleOwner = this@HomeFragment
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        lifecycle.addObserver(homeViewModel)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_home_top, menu).apply {
            menu?.let {
                this@HomeFragment.menu = it
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.itemId.let {
            when (it) {
                R.id.action_menu_home_favorite -> homeViewModel.onFavoriteClick()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
