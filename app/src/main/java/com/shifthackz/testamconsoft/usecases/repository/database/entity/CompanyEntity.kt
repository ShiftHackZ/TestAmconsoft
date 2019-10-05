package com.shifthackz.testamconsoft.usecases.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "companies")
data class CompanyEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("name")
    val name: String,
    @SerializedName("catchPhraze")
    val catchPhraze: String,
    @SerializedName("bs")
    val bs: String?
)