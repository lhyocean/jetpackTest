package com.bj.ocean.jetpack.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import java.util.*

/**
 * Created by ocean on 2020-04-22
 * @describe:
 */

@Entity(
    tableName = "garden_plantings",
    foreignKeys = [ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plant_id"])],
    indices = [Index("plant_id")]
)
data class GardenPlanting(

    @ColumnInfo(name = "plant_id")
    val plantId: String,
    @ColumnInfo(name = "plant_date")
    val plantData: Calendar = Calendar.getInstance(),
    @ColumnInfo(name = "last_watering_date")
    val lastWateringDate: Calendar = Calendar.getInstance()
) {

}
