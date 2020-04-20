package com.bj.ocean.jetpack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by ocean on 2020-04-16
 * @describe:
 */
@Dao
interface PlantDao {

    /**
     *
     */
    @Query("select * from plants order by name")
    fun  getPlants():LiveData<List<Plant>>


    @Query("select * from plants where id = :plantId")
    fun getPlant(plantId:String):LiveData<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Plant>)

    @Query("select * from plants where growZoneNumber = :growZoneNumber order by name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber:Int):LiveData<List<Plant>>






}