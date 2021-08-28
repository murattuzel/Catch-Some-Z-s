package com.murattuzel.catchsomezs.ui.mediadetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseFragment
import com.murattuzel.catchsomezs.databinding.FragmentMediaDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MediaDetailFragment(
    override val layoutId: Int = R.layout.fragment_media_detail
) : BaseFragment<MediaDetailViewModel, FragmentMediaDetailBinding>() {
    private val args by navArgs<MediaDetailFragmentArgs>()

    @Inject
    lateinit var viewModelFactory: MediaDetailViewModelFactory

    override val viewModel: MediaDetailViewModel by viewModels {
        MediaDetailViewModel.provideFactory(
            viewModelFactory,
            args.argToolbarTitle,
            args.argHeader,
            args.argDescription,
            args.argDate
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.mediaDetailToolBar.setNavigationOnClickListener { viewModel.navigateBack() }
    }
}
