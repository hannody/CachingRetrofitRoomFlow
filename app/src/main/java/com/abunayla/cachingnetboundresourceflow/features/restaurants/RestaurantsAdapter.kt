package com.abunayla.cachingnetboundresourceflow.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abunayla.cachingnetboundresourceflow.data.RestaurantItem
import com.abunayla.cachingnetboundresourceflow.databinding.RestaurantItemBinding
import com.bumptech.glide.Glide

class RestaurantsAdapter :
    ListAdapter<RestaurantItem, RestaurantsAdapter.RestaurantViewHolder>(RestaurantComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :

        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurantItem: RestaurantItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurantItem.logo)
                    .into(ivLogo)
                tvName.text = restaurantItem.name
                tvType.text = restaurantItem.type
                tvAddress.text = restaurantItem.address

            }

        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<RestaurantItem>() {
        override fun areItemsTheSame(oldItem: RestaurantItem, newItem: RestaurantItem) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: RestaurantItem, newItem: RestaurantItem) =
            oldItem == newItem
    }
}