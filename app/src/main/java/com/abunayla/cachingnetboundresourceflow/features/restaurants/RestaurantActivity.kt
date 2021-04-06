package com.abunayla.cachingnetboundresourceflow.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abunayla.cachingnetboundresourceflow.R
import com.abunayla.cachingnetboundresourceflow.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    private val viewModel: RestaurantsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantsAdapter = RestaurantsAdapter()

        binding.apply {
            rvRestaurants.apply {
                adapter = restaurantsAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }
            viewModel.restaurants.observe(this@RestaurantActivity){ restaurants ->
                restaurantsAdapter.submitList(restaurants)

            }
        }
    }
}