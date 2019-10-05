package com.shifthackz.testamconsoft.usecases.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "geo")
data class GeoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("lng")
    val lng: Float
)