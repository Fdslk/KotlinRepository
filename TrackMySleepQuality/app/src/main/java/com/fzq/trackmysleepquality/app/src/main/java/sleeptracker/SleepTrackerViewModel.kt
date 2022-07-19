package com.fzq.trackmysleepquality.app.src.main.java.sleeptracker

import android.content.Context
import androidx.lifecycle.ViewModel
import com.fzq.trackmysleepquality.app.src.main.java.database.SleepDatabaseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class SleepTrackerViewModel @Inject constructor(
    val database: SleepDatabaseDao,
    @ApplicationContext val application: Context
) : ViewModel() {
}