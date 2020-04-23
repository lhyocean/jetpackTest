package com.bj.ocean.jetpack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.bj.ocean.jetpack.utils.DATABASE_NAME
import com.bj.ocean.jetpack.workers.SeedDatabaseWorker

/**
 * Created by ocean on 2020-04-16
 * @describe:
 */
@Database(entities = [Plant::class,GardenPlanting::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase :RoomDatabase(){
   abstract fun plantDao():PlantDao
   abstract fun gardenPlantingDao(): GardenPlantingDao


    companion object{
      @Volatile private var instance:AppDatabase?=null

      fun getInstance(context: Context) :AppDatabase{

         return instance?: synchronized(this){
            instance?:buildDataBase(context).also{ instance=it}
         }
      }
      // //  init database and read data from assets insert data
      private fun buildDataBase(context: Context): AppDatabase
      {
         return Room.databaseBuilder(context,AppDatabase::class.java,DATABASE_NAME)
            .addCallback(object :RoomDatabase.Callback(){
               override fun onCreate(db: SupportSQLiteDatabase) {
                  super.onCreate(db)
                  val request= OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                  WorkManager.getInstance(context).enqueue(request)
               }
            })
            .build()

      }


   }





}