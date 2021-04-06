package com.abunayla.cachingnetboundresourceflow.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abunayla.cachingnetboundresourceflow.api.RestaurantAPI
import com.abunayla.cachingnetboundresourceflow.data.RestaurantItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(api: RestaurantAPI) : ViewModel() {
    private val restaurantsLiveData = MutableLiveData<List<RestaurantItem>>()
    val restaurants : LiveData<List<RestaurantItem>> = restaurantsLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()

            // delay is used here just to show the progress bar, it should be removed from production app code
            delay(2000)
            restaurantsLiveData.value = restaurants
        }

    }
}