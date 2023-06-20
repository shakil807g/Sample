package com.sample.ui.list

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback : DiffUtil.ItemCallback<ListItemUi>() {
    override fun areItemsTheSame(oldItem: ListItemUi, newItem: ListItemUi): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ListItemUi, newItem: ListItemUi): Boolean {
        return oldItem == newItem
    }

}