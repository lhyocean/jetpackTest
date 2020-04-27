package com.bj.ocean.jetpack.viewmodel

import com.bj.ocean.jetpack.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by ocean on 2020-04-27
 * @describe:
 */
class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlantings = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlantings.lastWateringDate.time)
    val wateringInterval get() = plant.wateringInterval
    val imageUrl get() = plant.imageUrl
    val plantName get() = plant.name
    val plantId get() = plant.plantId
    val plantDateString: String = dateFormat.format(gardenPlantings.plantDate.time)


    companion object {
        private val dateFormat = SimpleDateFormat("MMM d,yyyy", Locale.CHINA)
    }
}