package com.durov.recyclerviewkotlin_01

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.durov.recyclerviewkotlin_01.databinding.ItemViewBinding

class MyItemViewAdapter(
    private val items: List<Person>
    , private val context: Context
    , private val itemClick: (Person) -> Unit
) : RecyclerView.Adapter<MyItemViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyItemViewAdapter.ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_view,
                parent,
                false
            ), itemClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(var itemViewBinding: ItemViewBinding, var itemClick: (Person) -> Unit) :
        RecyclerView.ViewHolder(itemViewBinding.root) {

        fun onClick(person: Person) {
            itemClick(person)
        }


        fun bindViewHolder(person: Person) {
            itemViewBinding.person = person
            itemViewBinding.handler = this

        }
    }


}