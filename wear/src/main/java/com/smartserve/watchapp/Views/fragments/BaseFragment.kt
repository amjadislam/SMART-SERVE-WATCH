package com.smartserve.watchapp.Views.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation

import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.*
import com.smartserve.watchapp.Utils.GeneralUtils.DialogUtils
import com.smartserve.watchapp.Utils.GeneralUtils.SessionManager
import com.smartserve.watchapp.ViewModels.BaseAndroidViewModel
import com.smartserve.watchapp.Views.activities.MainActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    lateinit var dialog: AlertDialog
    val sessionManager: SessionManager by inject { parametersOf(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = DialogUtils.getProgressDialog(requireContext())
    }


    abstract fun initViews()

    abstract fun attachViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        attachViewModel()


    }


    fun showProgressDialog(show: Boolean) {

        if (dialog != null && show) {
            if (!dialog.isShowing)
                dialog.apply {
                    show()
                }
        } else if (dialog != null && !show) {
            if (dialog.isShowing)
                dialog.dismiss()
        }
    }


    fun navigateToFragment(action: Int, bundle: Bundle? = null) {

        val navController =
            Navigation.findNavController(activity as MainActivity, R.id.nav_host_fragment)
        navController.navigate(action, bundle)

    }





    protected fun setupGeneralViewModel(generalViewModel: BaseAndroidViewModel) {

        with(generalViewModel)
        {
            snackbarMessage.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    showAlertDialog(it)
                }
            })

            progressBar.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    showProgressDialog(it)
                }
            })
        }
    }


    protected fun onBackPress() {
        requireActivity().onBackPressed()
    }


}
