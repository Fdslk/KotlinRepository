package com.fzq.trackmysleepquality

import android.content.Context
import com.fzq.trackmysleepquality.database.SleepDatabase
import com.fzq.trackmysleepquality.database.SleepDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {
    @Provides
    fun provideSleepDatabaseDao(@ApplicationContext context: Context): SleepDatabaseDao {
        return SleepDatabase.getInstance(context).sleepDatabaseDao
    }
}