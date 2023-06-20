package com.sample.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.R
import java.util.Locale

class ListItemAdapter(
    private val onItemClickListener: (ListItemUi) -> Unit) :
    ListAdapter<ListItemUi, ListItemAdapter.ItemViewHolder>(ItemDiffCallback()), Filterable {

    private var list = listOf<ListItemUi>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_character,
            parent, false
        )
        return ItemViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class ItemViewHolder(itemView: View, val onItemClickListener: (ListItemUi) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)

        fun bindTo(item: ListItemUi) {
            name.text = item.name
            name.setOnClickListener {
                onItemClickListener(item)
            }
        }
    }

    fun setData(newList: List<ListItemUi>){
        this.list = newList
        submitList(list)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = mutableListOf<ListItemUi>()
                if (constraint.isNullOrEmpty()) {
                    filteredList.addAll(list)
                } else {
                    for (item in list) {
                        if (item.name.toLowerCase(Locale.ROOT).startsWith(constraint.toString().toLowerCase())) {
                            filteredList.add(item)
                        }
                    }
                }
                val results = FilterResults()
                results.values = filteredList.toList()
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                submitList(results?.values as List<ListItemUi>)
            }
        }
    }

}