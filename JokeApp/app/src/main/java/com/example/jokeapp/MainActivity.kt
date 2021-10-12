package com.example.jokeapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.jokeapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myJokeBook: JokeBook = JokeBook()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.joke = myJokeBook
        setClickListeners()


        //jokeTextView = findViewById(R.id.joke_textview)
        //nextJokeButton.text = "Different Text"

        /*binding.nextJokeButton.setOnClickListener {
            showNextButton()
        }
        binding.nextSmileButton.setOnClickListener {
            showNextSmiley()
        }*/
    }

    private fun setClickListeners() {
        val clickableObjects = listOf(binding.nextJokeButton, binding.nextSmileButton)

        for (item in clickableObjects) {
            when (item.id) {
                R.id.nextSmile_button -> item.setOnClickListener {
                    showNextSmiley()
                }
                R.id.nextJoke_button -> item.setOnClickListener {
                    showNextButton()
                }
            }
        }
    }

    private fun showNextSmiley() {

        var randomNumber = Random.nextInt(3)


        var source = when (randomNumber) {
            0 -> R.drawable.ic_iconmonstr_smiley_1
            1 -> R.drawable.ic_iconmonstr_smiley_13
            else -> R.drawable.ic_iconmonstr_smiley_2
        }

        binding.smileyImageview.setImageResource(source)
    }

    private fun showNextButton() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        //var jokeTextView: TextView = findViewById(R.id.joke_textview)

        myJokeBook.changeCurrentJoke()
        binding.invalidateAll()
    }


}