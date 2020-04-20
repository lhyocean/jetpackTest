package com.bj.ocean.jetpack.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bj.ocean.jetpack.data.AppDatabase
import com.bj.ocean.jetpack.data.Plant
import com.bj.ocean.jetpack.utils.PLANT_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import java.lang.Appendable
import kotlin.Exception


/**
 * Created by ocean on 2020-04-16
 * @describe:
 */
class SeedDatabaseWorker(
    context: Context
    , workerParameters: WorkerParameters
) :
    CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(PLANT_DATA_FILENAME).use {
                JsonReader(it.reader()).use {
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantLsit: List<Plant> = Gson().fromJson(it, plantType)
                    val database = AppDatabase.getInstance(applicationContext)
                    database.plantDao().insertAll(plantLsit)
                    Result.success()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }


    }
}