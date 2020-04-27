package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bj.ocean.jetpack.data.GardenPlantingRepository
import com.bj.ocean.jetpack.data.PlantAndGardenPlantings

/**
 * Created by ocean on 2020-04-27
 * @describe:
 */
class GardenPlantingListViewModel(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}