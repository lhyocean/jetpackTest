package com.bj.ocean.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bj.ocean.jetpack.data.GardenPlantingRepository

/**
 * Created by ocean on 2020-04-27
 * @describe:
 */
class GardenPlantListViewModelFactory(private val repository: GardenPlantingRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}