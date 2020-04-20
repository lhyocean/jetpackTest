package com.bj.ocean.jetpack.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

import androidx.savedstate.SavedStateRegistryOwner
import com.bj.ocean.jetpack.data.PlantRepository

/**
 * Created by ocean on 2020-04-20
 * @describe:
 */
class PlantListViewModelFactory(
    private val respository: PlantRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return PlantListViewModel(respository, handle) as T
    }
}