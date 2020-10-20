package com.smartserve.watchapp.Views.fragments

import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.loadMenuItems
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.HomeMenuAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(R.layout.fragment_home), BaseAdapter.OnItemClicker {
    override fun initViews() {
        rvMenu.adapter = HomeMenuAdapter(rvMenu.loadMenuItems(),this)

        arguments?.let {
            HomeFragmentArgs.fromBundle(it).test
        }
    }

    override fun attachViewModel() {
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}