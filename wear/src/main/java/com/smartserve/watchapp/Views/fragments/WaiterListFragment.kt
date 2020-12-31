package com.smartserve.watchapp.Views.fragments

import com.rapidzz.garageapp.ViewModels.MainFunctionsViewModel
import com.smartserve.watchapp.Models.DataModels.GeneralModels.WaiterModels.WaitStaff
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.showToast
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.WaiterListAdapter
import kotlinx.android.synthetic.main.fragment_waiter_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class WaiterListFragment : BaseFragment(R.layout.fragment_waiter_list), BaseAdapter.OnItemClicker {


    val viewModel: MainFunctionsViewModel by viewModel()

    var waitersList = ArrayList<WaitStaff>()
    var waiterListAdapter:WaiterListAdapter ?= null


    override fun initViews() {
        waiterListAdapter= WaiterListAdapter(waitersList,this)
        rvWaiterList.adapter = waiterListAdapter
    }



    override fun attachViewModel() {

        with(viewModel)
        {
            setupGeneralViewModel(this)
            waiterResponseLiveData.observe(viewLifecycleOwner){
                it.getContentIfNotHandled()?.let {
                    showToast(it.message)
                    waitersList.clear()
                    it.data.forEach {
                        waitersList.addAll(it.wait_staff)
                    }
                    waiterListAdapter?.notifyDataSetChanged()
                }
            }

            getWaiters()
        }
    }

    override fun onItemClick(position: Int, data: Any) {

    }
}