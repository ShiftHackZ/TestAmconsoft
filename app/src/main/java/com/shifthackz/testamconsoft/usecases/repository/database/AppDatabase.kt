package com.shifthackz.testamconsoft.usecases.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shifthackz.testamconsoft.usecases.repository.database.converter.RoomConverter
import com.shifthackz.testamconsoft.usecases.repository.database.dao.UserDao
import com.shifthackz.testamconsoft.usecases.repository.database.entity.AddressEntity
import com.shifthackz.testamconsoft.usecases.repository.database.entity.CompanyEntity
import com.shifthackz.testamconsoft.usecases.repository.database.entity.GeoEntity
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity

@Database(entities = [UserEntity::class, GeoEntity::class, CompanyEntity::class, AddressEntity::class], version = 1)
@TypeConverters(RoomConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
