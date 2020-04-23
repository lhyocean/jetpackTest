package com.bj.ocean.jetpack.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by ocean on 2020-04-23
 * @describe:
 */
data class PlantAndGardenPlantings (
    @Embedded  //  数据关联
    val plant: Plant,

    @Relation (parentColumn = "id",entityColumn = "plant_id")
     val gardenPlantings: List<GardenPlanting> = emptyList()
){
}