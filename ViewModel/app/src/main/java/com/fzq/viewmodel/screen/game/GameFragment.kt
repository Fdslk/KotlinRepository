package com.fzq.viewmodel.screen.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.fzq.viewmodel.R
import com.fzq.viewmodel.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )
        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }

        binding.endGameButton.setOnClickListener { onEndGame() }
        // Inflate the layout for this fragment

        viewModel.score.observe(viewLifecycleOwner, Observer {
            newScore -> binding.scoreText.text = newScore.toString()
        })

        viewModel.word.observe(viewLifecycleOwner, Observer {
                newWord -> binding.wordText.text = newWord
        })
        return binding.root
    }

    private fun onEndGame() {
        gameFinished()
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score.value?:0
        NavHostFragment.findNavController(this).navigate(action)
    }

    /** Methods for buttons presses **/

    private fun onSkip() {
        viewModel.onSkip()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
    }

}