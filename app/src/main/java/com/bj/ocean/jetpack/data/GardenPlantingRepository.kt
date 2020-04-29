package com.bj.ocean.jetpack.data

import android.util.Log
import java.util.*
import kotlin.math.log

/**
 * Created by ocean on 2020-04-23
 * @describe:
 */
class GardenPlantingRepository private constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {

    suspend fun createdGardenPlanting(plantId:String){
        val gardenPlanting=GardenPlanting(plantId)
         gardenPlanting.test_id= Random().nextInt(10)
        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }
    suspend fun removeGardenPlanting(gardenPlanting: String) {
    }

    fun isPlanted(plantId: String)=gardenPlantingDao.isPlanted(plantId)
    fun getPlantedGardens()=gardenPlantingDao.getPlantedGardens()

    companion object {
        @Volatile
        private var instance: GardenPlantingRepository? = null

        fun getInstance(gardenPlantingDao: GardenPlantingDao) =
            instance ?: synchronized(this) {
                instance ?: GardenPlantingRepository(gardenPlantingDao).also { instance = it }
            }
    }
}