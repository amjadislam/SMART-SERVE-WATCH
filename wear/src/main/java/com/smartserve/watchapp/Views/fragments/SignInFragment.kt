package com.smartserve.watchapp.Views.fragments


import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.Device
import com.smartserve.watchapp.Models.DataModels.RequestModels.LoginRequestModel.LoginRequestModel
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Utils.Application.getString
import com.smartserve.watchapp.Utils.Application.getUniqueAndroidId
import com.smartserve.watchapp.Utils.Application.showToast
import com.smartserve.watchapp.Views.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*


class SignInFragment : BaseFragment(R.layout.activity_login) {


    val viewModel: ProfileViewModel by viewModel()


    override fun attachViewModel() {
        setupGeneralViewModel(viewModel)
        with(viewModel)
        {
            userLiveData.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {

                    sessionManager.setUser(it)
                    (requireActivity() as BaseActivity).gotoMainActivity()
                }
            })
        }


    }


    override fun initViews() {
        btnSignIn.setOnClickListener {
            if (editText_loginCode.getString().isNullOrEmpty()) {
                showToast("Login code required !!")
            } else {
                val loginRequestModel = LoginRequestModel(
                    Device(
                        "android",
                        sessionManager.getFCMToken(),
                        requireContext().getUniqueAndroidId()
                    ),
                    editText_loginCode.getString()
                )
                viewModel.loginUser(loginRequestModel)
            }
        }

    }
}