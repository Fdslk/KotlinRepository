package com.fzq.trackmysleepquality.sleepquality

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
 * Use the [SleepQualityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SleepQualityFragment : Fragment() {
    val viewModel: SleepQualityViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sleep_quality, container, false)
    }
}