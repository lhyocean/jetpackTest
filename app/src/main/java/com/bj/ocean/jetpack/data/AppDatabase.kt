package com.bj.ocean.jetpack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * Created by ocean on 2020-04-16
 * @describe:
 */
@Database(entities = [Plant::class],version = 1,exportSchema = false)
@TypeConverters
abstract class AppDatabase :RoomDatabase(){





}