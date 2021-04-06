package com.abunayla.cachingnetboundresourceflow.api

import com.abunayla.cachingnetboundresourceflow.data.RestaurantItem
import retrofit2.http.GET

interface RestaurantAPI {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<RestaurantItem>
}