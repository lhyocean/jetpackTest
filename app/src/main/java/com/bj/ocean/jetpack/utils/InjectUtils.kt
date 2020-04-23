package com.bj.ocean.jetpack.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.bj.ocean.jetpack.data.AppDatabase
import com.bj.ocean.jetpack.data.GardenPlantingRepository
import com.bj.ocean.jetpack.data.Plant
import com.bj.ocean.jetpack.data.PlantRepository
import com.bj.ocean.jetpack.viewmodel.PlantDetailViewModelFactory
import com.bj.ocean.jetpack.viewmodel.PlantListViewModelFactory

/**
 * Created by ocean on 2020-04-20
 * @describe:
 */
object InjectUtils {


    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(AppDatabase.getInstance(context.applicationContext).plantDao())
    }

    fun providePlantListViewModelFactory(fragment: Fragment): PlantListViewModelFactory {

        val repository = getPlantRepository(fragment.requireContext())
        return PlantListViewModelFactory(repository, fragment)
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).gardenPlantingDao()
        )
    }


    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(
            getPlantRepository(context),
            getGardenPlantingRepository(context), plantId
        )
    }
}