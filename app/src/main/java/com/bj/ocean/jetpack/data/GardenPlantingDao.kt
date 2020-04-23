package com.bj.ocean.jetpack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by ocean on 2020-04-22
 * @describe:
 */
@Dao
interface GardenPlantingDao {

    @Query("select * from garden_plantings")
    fun getGardenPlantings():LiveData<List<GardenPlanting>>

    @Query("select exists (select 1 from garden_plantings where plant_id= :plantId limit 1)")
    fun isPlanted(plantId :String):LiveData<Boolean>

    @Query("select * from plants where id in (select distinct (plant_id) from garden_plantings)")
    fun getPlantedGardens():LiveData<List<PlantAndGardenPlantings>>

    @Insert
    suspend fun insertGardenPlanting(gardenPlanting: GardenPlanting): Long

}