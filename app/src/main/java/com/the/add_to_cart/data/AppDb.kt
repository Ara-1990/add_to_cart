package com.the.add_to_cart.data

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CartEntity::class], version = 1, exportSchema = false)

abstract class AppDb : RoomDatabase() {

    abstract fun userDao(): CartDao

    companion object {
        @Volatile
        private var INSTANCE: AppDb? = null


        fun getDatabase(context: Context): AppDb {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "image_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance



                instance
            }
        }
    }

}