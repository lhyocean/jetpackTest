package com.bj.ocean.jetpack.data

/**
 * Created by ocean on 2020-04-13
 * @describe:
 */
data class Plant(
    val name: String,
    val plantId: String,
    val description: String,
    val imageUrl: String,
    val growZoneNumber: Int,
    val wateringInterval: Int=7
) {
    override fun toString(): String =name
}