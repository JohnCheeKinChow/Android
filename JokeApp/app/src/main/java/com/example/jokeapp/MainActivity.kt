package com.example.jokeapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var jokeTextView: TextView
    lateinit var SmileyImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nextJokeButton: Button = findViewById(R.id.nextJoke_button)
        var nextSmileyButton: Button = findViewById(R.id.nextSmile_button)

        jokeTextView = findViewById(R.id.joke_textview)
        //nextJokeButton.text = "Different Text"
        nextJokeButton.setOnClickListener {
            showNextButton()
        }
        nextSmileyButton.setOnClickListener {
            showNextSmiley()
        }
    }

    private fun showNextSmiley() {

        var randomNumber = Random.nextInt(3)


        var source = when (randomNumber) {
            0 -> R.drawable.ic_iconmonstr_smiley_1
            1 -> R.drawable.ic_iconmonstr_smiley_13
            else -> R.drawable.ic_iconmonstr_smiley_2
        }

        SmileyImage.setImageResource(source)
    }

    private fun showNextButton() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        //var jokeTextView: TextView = findViewById(R.id.joke_textview)
        var myJokeBook: jokebook = jokebook()
        jokeTextView.text = myJokeBook.getRandomJoke()
    }
}