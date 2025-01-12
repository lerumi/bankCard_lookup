package com.example.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CardEntity::class], version = 1)
abstract class QueryDb : RoomDatabase() {
    abstract  fun CardDao():CardDao
    companion object{
        @Volatile
        private var INSTANCE: QueryDb? = null
        fun createDataBase(context: Context): QueryDb{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QueryDb::class.java,
                    name = "querys"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}