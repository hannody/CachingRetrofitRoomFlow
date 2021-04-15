package com.abunayla.cachingnetboundresourceflow.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RestaurantItem::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}