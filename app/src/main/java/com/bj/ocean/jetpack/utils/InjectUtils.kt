package com.bj.ocean.jetpack.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.bj.ocean.jetpack.data.AppDatabase
import com.bj.ocean.jetpack.data.PlantRepository
import com.bj.ocean.jetpack.viewmodel.PlantListViewModelFactory

/**
 * Created by ocean on 2020-04-20
 * @describe:
 */
object InjectUtils {


    private fun getPlantRepository(context: Context):PlantRepository
    {
        return PlantRepository.getInstance(AppDatabase.getInstance(context.applicationContext).plantDao())
    }

     fun providePLantListViewModelFactory(fragment: Fragment):PlantListViewModelFactory{

        val repository= getPlantRepository(fragment.requireContext())
        return PlantListViewModelFactory(repository,fragment)
    }
}