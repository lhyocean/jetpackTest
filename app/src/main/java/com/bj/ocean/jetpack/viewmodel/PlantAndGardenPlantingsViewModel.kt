package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bj.ocean.jetpack.data.GardenPlanting
import com.bj.ocean.jetpack.data.GardenPlantingRepository
import com.bj.ocean.jetpack.data.PlantAndGardenPlantings
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by ocean on 2020-04-27
 * @describe:
 */
class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings,val repository: GardenPlantingRepository):ViewModel() {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlantings = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlantings.lastWateringDate.time)
    val wateringInterval get() = plant.wateringInterval
    val imageUrl get() = plant.imageUrl
    val plantName get() = plant.name
    val plantId get() = plant.plantId
    val plantDateString: String = dateFormat.format(gardenPlantings.plantDate.time)
    val test_id:String=gardenPlantings.test_id.toString()

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d,yyyy", Locale.CHINA)
    }

    fun removDate(plantId:String){
        viewModelScope.launch {

            repository.removeGardenPlanting(plantId)
        }
    }

}