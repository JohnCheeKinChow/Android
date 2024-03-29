package com.example.jokeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jokeapp.databinding.FragmentHomeBinding
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


    private val myJokeBook = JokeBook("")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Step 1, use databinding to inflate the xml

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.joke = myJokeBook

        setOnClickListeners()

        return binding.root
    }

    //set click listener for each element in the list
    private fun setOnClickListeners() {
        val clickableElements = listOf(
            binding.happyButton,
            binding.nextjokeButton
        )
        for (item in clickableElements){
            when(item.id){
                R.id.nextjoke_button -> item.setOnClickListener { changeJoke() }
                R.id.happy_button -> item.setOnClickListener { happy() }
            }
        }
    }

    private fun happy() {
        val drawableResource = when (Random.nextInt(3)) {
            0 -> R.drawable.ic_iconmonstr_smiley_1
            1 -> R.drawable.ic_iconmonstr_smiley_13
            else -> R.drawable.ic_iconmonstr_smiley_2

        }
        binding.happyImage.setImageResource(drawableResource)
    }

    private fun changeJoke() {
        //binding.jokeTextview.text = myJokeBook.getRandomJoke()
        myJokeBook.changeCurrentJoke()
        binding.invalidateAll() //important! this binds the new data.
    }

}