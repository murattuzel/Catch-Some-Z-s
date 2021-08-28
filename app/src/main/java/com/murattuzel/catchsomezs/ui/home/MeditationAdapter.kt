package com.murattuzel.catchsomezs.ui.home

import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseListAdapter
import com.murattuzel.catchsomezs.databinding.ItemMeditationBinding
import com.murattuzel.catchsomezs.domain.model.MeditationUiModel

class MeditationAdapter(
    private val viewModel: HomeViewModel
) : BaseListAdapter<ItemMeditationBinding, MeditationUiModel>() {

    override val layoutRes: Int = R.layout.item_meditation

    override fun bind(binding: ItemMeditationBinding, item: MeditationUiModel) {
        binding.uiModel = item
        binding.viewModel = viewModel
    }
}
