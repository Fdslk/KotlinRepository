package com.fzq.androidtrivia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.fzq.androidtrivia.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener { view: View ->
//            view.findNavController()
//                .navigate(R.id.action_gameWonFragment_to_gameFragment, null)
            view.findNavController()
                .navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()
        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent
    @SuppressLint("StringFormatInvalid")
    private fun getShareIntent() : Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
        return shareIntent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        if(getShareIntent().resolveActivity(requireActivity().packageManager)==null){
            menu.findItem(R.string.share).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
