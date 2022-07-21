package com.fzq.trackmysleepquality.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.fzq.trackmysleepquality.R
import com.fzq.trackmysleepquality.database.SleepDatabase
import com.fzq.trackmysleepquality.databinding.FragmentSleepTrackerBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [SleepTrackerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SleepTrackerFragment : Fragment() {

    val sleepTrackerViewModel: SleepTrackerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSleepTrackerBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sleep_tracker,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.sleepTrackerViewModel = this.sleepTrackerViewModel
/*
        non DI way for create viewModel
        val application = requireNotNull(this.activity).application
        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao
        val sleepTrackerViewModelFactory = SleepTrackerViewModelFactory(dataSource, application)
        val trackerViewModelByFactory =
            ViewModelProvider(this, sleepTrackerViewModelFactory)[SleepTrackerViewModel::class.java]
*/

        return binding.root
    }
}