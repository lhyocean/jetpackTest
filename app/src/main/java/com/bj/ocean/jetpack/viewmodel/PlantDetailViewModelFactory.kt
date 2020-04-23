package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bj.ocean.jetpack.data.GardenPlantingRepository
import com.bj.ocean.jetpack.data.PlantRepository

/**
 * Created by ocean on 2020-04-23
 * @describe:
 */
class PlantDetailViewModelFactory(

    private val plantRespoitory: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return PlantDetailViewModel(plantRespoitory, gardenPlantingRepository, plantId) as T
    }
}