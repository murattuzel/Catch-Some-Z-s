package com.murattuzel.catchsomezs.ui.home

import com.murattuzel.catchsomezs.R
import com.murattuzel.catchsomezs.base.BaseListAdapter
import com.murattuzel.catchsomezs.databinding.ItemStoryBinding
import com.murattuzel.catchsomezs.domain.model.StoryUiModel

class StoryAdapter(
    private val viewModel: HomeViewModel
) : BaseListAdapter<ItemStoryBinding, StoryUiModel>() {

    override val layoutRes: Int = R.layout.item_story

    override fun bind(binding: ItemStoryBinding, item: StoryUiModel) {
        binding.uiModel = item
        binding.viewModel = viewModel
    }
}
