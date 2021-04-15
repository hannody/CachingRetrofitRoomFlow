package com.abunayla.cachingnetboundresourceflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class RestaurantItem(
    @PrimaryKey val name: String,
    val type: String,
    val logo: String,
    val address: String
)