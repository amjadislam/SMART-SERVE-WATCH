package com.smartserve.watchapp.Views.fragments

import com.rapidzz.garageapp.ViewModels.MainFunctionsViewModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.getCurrentDate
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.NotificationAdapter
import kotlinx.android.synthetic.main.fragment_notification.*
import org.koin.android.viewmodel.ext.android.viewModel

class NotificationFragment : BaseFragment(R.layout.fragment_notification),
    BaseAdapter.OnItemClicker {



    val viewModel:MainFunctionsViewModel by viewModel()

    var notifications = ArrayList<String>()
    var notificationAdapter:NotificationAdapter ?=  null




    override fun initViews() {
        notificationAdapter=NotificationAdapter(notifications,this)
        rvNotification.adapter = notificationAdapter
    }


    override fun attachViewModel() {
        with(viewModel)
        {
            setupGeneralViewModel(this)
            notificationResponseLiveData.observe(viewLifecycleOwner){
                it.getContentIfNotHandled()?.let {

                }
            }
            getNotifications(getCurrentDate())
        }

    }

    override fun onItemClick(position: Int, data: Any) {

    }
}