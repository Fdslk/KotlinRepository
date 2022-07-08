package com.fzq.viewmodel.screen.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//class ScoreViewModelFactory(final val finalScore: Int) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
//            return ScoreViewModel(finalScore) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}


class ScoreViewModelFactory(private val finalScore: Int): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}