package com.murattuzel.catchsomezs.ui.home

import android.os.Bundle
import android.view.View
import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseFragment
import com.murattuzel.catchsomezs.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(
    override val layoutId: Int = R.layout.fragment_home
) : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.meditationAdapter = MeditationAdapter(viewModel)
        binder.storyAdapter = StoryAdapter(viewModel)
    }
}
