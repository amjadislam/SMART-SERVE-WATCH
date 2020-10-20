package com.smartserve.watchapp.Views.activities

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.widget.ImageView
import androidx.navigation.NavController
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.adapters.BaseAdapter
import com.smartserve.watchapp.Views.dialog.ConfirmationDialog

class MainActivity : BaseActivity(), BaseAdapter.OnItemClicker {

    private lateinit var appBarConfiguration: AppBarConfiguration
    var navController: NavController? = null
    var needBackMove: Boolean = false
    var ivToolIcon: ImageView? = null




    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun onItemClick(position: Int, data: Any) {
        when (position) {
            3 -> {
                //                navController!!.navigate(R.id.changePasswordFragment)
            }
            5 -> {
                // logout()
            }
        }
    }


    override fun initViews() {


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun logout() {

        ConfirmationDialog("Are you sure to logout from app ?",
            object : ConfirmationDialog.ConfirmationListener {
                override fun isConfirmed(isConfirmed: Boolean) {
                    if (isConfirmed) {
                        sessionManager.logout()
                    }
                }
            }).show(supportFragmentManager, "")

    }
}
