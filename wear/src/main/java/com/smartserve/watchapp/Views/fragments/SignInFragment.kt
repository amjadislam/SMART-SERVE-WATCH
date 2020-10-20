package com.smartserve.watchapp.Views.fragments




import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import com.rapidzz.garageapp.ViewModels.ProfileViewModel
import com.smartserve.watchapp.Models.Source.Repository.DataRepository
import com.smartserve.watchapp.R
import com.smartserve.watchapp.Views.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*


class SignInFragment : BaseFragment(R.layout.activity_login) {


    val viewModel: ProfileViewModel by viewModel()


    override fun attachViewModel() {
        setupGeneralViewModel(viewModel)
        with(viewModel)
        {
            userLiveData.observe(viewLifecycleOwner,  {
                it.getContentIfNotHandled()?.let {
                    sessionManager.setUser(it)
                    (requireActivity() as BaseActivity).gotoMainActivity()
                }

            })
        }

    }


    override fun initViews() {
        btnSignIn.setOnClickListener {
             navigateToFragment(SignInFragmentDirections.actionSignInFragmentToHomeFragment(true))
        }

    }
}