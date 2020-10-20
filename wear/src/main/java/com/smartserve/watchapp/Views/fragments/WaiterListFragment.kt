package com.smartserve.watchapp.Views.fragments

import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.WaiterListAdapter
import kotlinx.android.synthetic.main.fragment_waiter_list.*

class WaiterListFragment : BaseFragment(R.layout.fragment_waiter_list), BaseAdapter.OnItemClicker {



    override fun initViews() {
        rvWaiterList.adapter = WaiterListAdapter(waiters, this)
    }

    var waiters = ArrayList<String>()

    override fun attachViewModel() {
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}