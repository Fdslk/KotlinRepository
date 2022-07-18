package com.fzq.trackmysleepquality.app.src.main.java.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fzq.trackmysleepquality.app.src.main.java.database.SleepDatabaseDao

class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

}