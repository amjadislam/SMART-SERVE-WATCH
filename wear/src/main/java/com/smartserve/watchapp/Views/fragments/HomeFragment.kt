package com.smartserve.watchapp.Views.fragments

import android.util.Log
import androidx.lifecycle.observe
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LogoutRequestModel.LogoutRequestModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.loadMenuItems
import com.smartserve.watchapp.Utils.Application.showToast
import com.smartserve.watchapp.Views.activities.BaseActivity
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.HomeMenuAdapter
import com.smartserve.watchapp.Views.dialog.ConfirmationDialog
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(R.layout.fragment_home), BaseAdapter.OnItemClicker {


    val viewModel: ProfileViewModel by viewModel()


    override fun initViews() {
        rvMenu.adapter = HomeMenuAdapter(rvMenu.loadMenuItems(), this)
    }

    override fun attachViewModel() {
        with(viewModel)
        {
            setupGeneralViewModel(this)
            userLogoutLiveData.observe(viewLifecycleOwner) {
                it.getContentIfNotHandled()?.let {
                    showToast(it.message)
                    sessionManager.logout()
                    (requireActivity() as BaseActivity).gotoLoginActivity()
                }
            }

        }
    }

    override fun onItemClick(position: Int, data: Any) {
        when (position) {
            0 -> {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToNotificationFragment())
            }

            1 -> {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToWaiterListFragment())
            }

            2 -> {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToPaidBillFragment())
            }

            3 -> {
                logout()
            }
        }
    }


    private fun logout() {

        ConfirmationDialog("Are you sure to logout from app ?",
            object : ConfirmationDialog.ConfirmationListener {
                override fun isConfirmed(isConfirmed: Boolean) {
                    if (isConfirmed) {
                        viewModel.logoutUser(LogoutRequestModel(sessionManager.getUserId()))
                    }
                }
            }).show(childFragmentManager, "")

    }
}