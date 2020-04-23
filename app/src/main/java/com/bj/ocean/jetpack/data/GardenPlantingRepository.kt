package com.bj.ocean.jetpack.data

/**
 * Created by ocean on 2020-04-23
 * @describe:
 */
class GardenPlantingRepository private constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {

    suspend fun createdGardenPlanting(plantId:String){
        val gardenPlanting=GardenPlanting(plantId)
        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
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