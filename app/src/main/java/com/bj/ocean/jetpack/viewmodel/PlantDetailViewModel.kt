package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bj.ocean.jetpack.data.GardenPlantingRepository
import com.bj.ocean.jetpack.data.PlantRepository
import kotlinx.coroutines.launch

/**
 * Created by ocean on 2020-04-23
 * @describe:
 */
class PlantDetailViewModel(
    plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository
    , private val plantId: String
) : ViewModel() {
    val plant = plantRepository.getPlant(plantId)
    val isPlanted = gardenPlantingRepository.isPlanted(plantId)
    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createdGardenPlanting(plantId)
        }
    }
}