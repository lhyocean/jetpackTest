package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.bj.ocean.jetpack.data.GardenPlanting
import com.bj.ocean.jetpack.data.GardenPlantingRepository
import com.bj.ocean.jetpack.data.PlantAndGardenPlantings
import kotlinx.coroutines.launch

/**
 * Created by ocean on 2020-04-27
 * @describe:
 */
class GardenPlantingListViewModel(
   private val gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()

}