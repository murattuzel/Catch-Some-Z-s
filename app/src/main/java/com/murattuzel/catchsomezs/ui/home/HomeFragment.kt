package com.murattuzel.catchsomezs.ui.home

import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseFragment
import com.murattuzel.catchsomezs.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(
    override val layoutId: Int = R.layout.fragment_home
) : BaseFragment<HomeViewModel, FragmentHomeBinding>()
