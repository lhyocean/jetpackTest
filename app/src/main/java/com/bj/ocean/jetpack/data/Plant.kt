package com.bj.ocean.jetpack.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ocean on 2020-04-13
 * @describe:
 */
@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey @ColumnInfo(name="id")
    val plantId: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val growZoneNumber: Int,
    val wateringInterval: Int=7
) {
    override fun toString(): String =name
}