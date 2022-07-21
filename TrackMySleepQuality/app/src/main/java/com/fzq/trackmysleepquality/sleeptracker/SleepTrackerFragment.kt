package com.fzq.trackmysleepquality.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fzq.trackmysleepquality.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [SleepTrackerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SleepTrackerFragment : Fragment() {

    val viewModel: SleepTrackerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sleep_tracker, container, false)
    }
}