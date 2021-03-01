package com.smartserve.watchapp.Views.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.core.content.ContextCompat
import androidx.lifecycle.observe
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LogoutRequestModel.LogoutRequestModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.loadImage
import com.smartserve.watchapp.Utils.Application.loadMenuItems
import com.smartserve.watchapp.Utils.Application.showToast
import com.smartserve.watchapp.Views.activities.BaseActivity
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.adapters.HomeMenuAdapter
import com.smartserve.watchapp.Views.dialog.ConfirmationDialog
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment(R.layout.fragment_home), BaseAdapter.OnItemClicker {


    val viewModel: ProfileViewModel by viewModel()
    var selectedPosition = -1

    @SuppressLint("ClickableViewAccessibility")
    override fun initViews() {
        handleNotificationClick()
        handleWaiterListClick()
        handlePaidBillsClick()
        handleLogoutClick()
        rvMenu.adapter = HomeMenuAdapter(rvMenu.loadMenuItems(), this, selectedPosition)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun handleNotificationClick() {
        llNotifications.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                // waiterlist
                tvWaiterListTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivWaiterList.setImageResource(R.drawable.ic_waiter_list_black)
                llWaiterList.setBackgroundResource(R.drawable.bg_rounded_white)

                //paid bills
                tvPaidBillsTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivPaidBills.setImageResource(R.drawable.ic_paid_billd_back)
                llPaidBills.setBackgroundResource(R.drawable.bg_rounded_white)

                //logout
                tvLogoutTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivLogout.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorBlack))
                llLogout.setBackgroundResource(R.drawable.bg_rounded_white)


                llNotifications.setBackgroundResource(R.drawable.bg_rounded_orange)
                tvNotificationTitle.setTextColor(resources.getColor(R.color.white))
                ivNotification.setImageResource(R.drawable.ic_notification_white)
                true
            }else if(event.action == MotionEvent.ACTION_UP) {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToNotificationFragment())
                true
            } else {
                false
            }
        })
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun handleWaiterListClick() {
        llWaiterList.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                //notification
                tvNotificationTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivNotification.setImageResource(R.drawable.ic_notifications_black)
                llNotifications.setBackgroundResource(R.drawable.bg_rounded_white)

                //paid bills
                tvPaidBillsTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivPaidBills.setImageResource(R.drawable.ic_paid_billd_back)
                llPaidBills.setBackgroundResource(R.drawable.bg_rounded_white)

                //logout
                tvLogoutTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivLogout.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorBlack))
                llLogout.setBackgroundResource(R.drawable.bg_rounded_white)


                llWaiterList.setBackgroundResource(R.drawable.bg_rounded_orange)
                tvWaiterListTitle.setTextColor(resources.getColor(R.color.white))
                ivWaiterList.setImageResource(R.drawable.ic_waiter_list_white)
                true
            }else if(event.action == MotionEvent.ACTION_UP) {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToWaiterListFragment())
                true
            } else {
                false
            }
        })
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun handlePaidBillsClick() {
        llPaidBills.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                //notification
                tvNotificationTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivNotification.setImageResource(R.drawable.ic_notifications_black)
                llNotifications.setBackgroundResource(R.drawable.bg_rounded_white)

                // waiterlist
                tvWaiterListTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivWaiterList.setImageResource(R.drawable.ic_waiter_list_black)
                llWaiterList.setBackgroundResource(R.drawable.bg_rounded_white)

                //logout
                tvLogoutTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivLogout.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorBlack))
                llLogout.setBackgroundResource(R.drawable.bg_rounded_white)

                llPaidBills.setBackgroundResource(R.drawable.bg_rounded_orange)
                tvPaidBillsTitle.setTextColor(resources.getColor(R.color.white))
                ivPaidBills.setImageResource(R.drawable.ic_paid_bills_white)
                true
            }else if(event.action == MotionEvent.ACTION_UP) {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToPaidBillFragment())
                true
            } else {
                false
            }
        })
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun handleLogoutClick() {
        llLogout.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                //notification
                tvNotificationTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivNotification.setImageResource(R.drawable.ic_notifications_black)
                llNotifications.setBackgroundResource(R.drawable.bg_rounded_white)

                // waiterlist
                tvWaiterListTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivWaiterList.setImageResource(R.drawable.ic_waiter_list_black)
                llWaiterList.setBackgroundResource(R.drawable.bg_rounded_white)

                //paid bills
                tvPaidBillsTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                ivPaidBills.setImageResource(R.drawable.ic_paid_billd_back)
                llPaidBills.setBackgroundResource(R.drawable.bg_rounded_white)

                llLogout.setBackgroundResource(R.drawable.bg_rounded_orange)
                tvLogoutTitle.setTextColor(resources.getColor(R.color.white))
                ivLogout.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorWhite))
                true
            }else if(event.action == MotionEvent.ACTION_UP) {
                logout()
                true
            } else {
                false
            }
        })
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
        selectedPosition = position
        rvMenu.adapter?.notifyDataSetChanged();
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
                    } else {
                        tvLogoutTitle.setTextColor(resources.getColor(R.color.colorDarkGray))
                        ivLogout.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorBlack))
                        llLogout.setBackgroundResource(R.drawable.bg_rounded_white)
                    }
                }
            }).show(childFragmentManager, "")
    }

    override fun onResume() {
        super.onResume()
        selectedPosition = -1
    }

}