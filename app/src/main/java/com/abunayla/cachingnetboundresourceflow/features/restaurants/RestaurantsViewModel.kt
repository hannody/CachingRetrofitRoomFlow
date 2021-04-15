package com.abunayla.cachingnetboundresourceflow.features.restaurants

import androidx.lifecycle.*
import com.abunayla.cachingnetboundresourceflow.api.RestaurantAPI
import com.abunayla.cachingnetboundresourceflow.data.RestaurantItem
import com.abunayla.cachingnetboundresourceflow.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(repository: RestaurantRepository) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}