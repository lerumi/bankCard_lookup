package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.database.QueryDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModel {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): QueryDb =
        QueryDb.createDataBase(context)
}