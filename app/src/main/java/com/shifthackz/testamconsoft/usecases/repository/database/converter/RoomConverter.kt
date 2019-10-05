package com.shifthackz.testamconsoft.usecases.repository.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shifthackz.testamconsoft.usecases.repository.database.entity.AddressEntity
import com.shifthackz.testamconsoft.usecases.repository.database.entity.CompanyEntity
import com.shifthackz.testamconsoft.usecases.repository.database.entity.GeoEntity
import java.lang.reflect.Type
import java.util.*

class RoomConverter {

    @TypeConverter
    fun geoToJson(geoEntity: GeoEntity): String {
        val gson = Gson()
        return gson.toJson(geoEntity)
    }

    @TypeConverter
    fun jsonToGeo(value: String): GeoEntity {
        val gson = Gson()
        val type = object : TypeToken<GeoEntity>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun addressToJson(addressEntity: AddressEntity): String {
        val gson = Gson()
        return gson.toJson(addressEntity)
    }

    @TypeConverter
    fun jsonToAddress(value: String): AddressEntity {
        val gson = Gson()
        val type = object : TypeToken<AddressEntity>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun companyToJson(companyEntity: CompanyEntity): String {
        val gson = Gson()
        return gson.toJson(companyEntity)
    }

    @TypeConverter
    fun jsonToCompany(value: String): CompanyEntity {
        val gson = Gson()
        val type = object : TypeToken<CompanyEntity>() {}.type
        return gson.fromJson(value, type)
    }
}