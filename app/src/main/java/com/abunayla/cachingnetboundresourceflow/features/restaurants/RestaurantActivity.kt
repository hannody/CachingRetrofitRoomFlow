package com.abunayla.cachingnetboundresourceflow.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.abunayla.cachingnetboundresourceflow.databinding.ActivityRestaurantBinding
import com.abunayla.cachingnetboundresourceflow.util.Resource
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


            viewModel.restaurants.observe(this@RestaurantActivity){ result ->
                restaurantsAdapter.submitList(result.data)
                pbLoading.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                tvLoadingErrorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                tvLoadingErrorMessage.text = result.error?.localizedMessage
            }
        }
    }
}