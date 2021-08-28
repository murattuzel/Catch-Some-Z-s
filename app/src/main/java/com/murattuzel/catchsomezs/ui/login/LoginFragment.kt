package com.murattuzel.catchsomezs.ui.login

import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseFragment
import com.murattuzel.catchsomezs.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment(
    override val layoutId: Int = R.layout.fragment_login
) : BaseFragment<LoginViewModel, FragmentLoginBinding>()
