package com.smartserve.watchapp.Views.fragments

import androidx.lifecycle.Observer
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.obtainViewModel
import com.smartserve.watchapp.Views.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class SignInFragment : BaseFragment(R.layout.activity_login) {



    private var viewModel : ProfileViewModel ? = null
    override fun attachViewModel() {

        viewModel=obtainViewModel(ProfileViewModel::class.java)

        setupGeneralViewModel(viewModel!!)
        with(viewModel)
        {
            this?.userLiveData?.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    sessionManager.setUser(it)
                    (requireActivity() as BaseActivity).gotoMainActivity()
                }

            })
        }

    }


    override fun initViews() {
        btnSignIn.setOnClickListener {
           // navigateToFragment(R.id.action_signInFragment_to_homeFragment)
        }

    }
}