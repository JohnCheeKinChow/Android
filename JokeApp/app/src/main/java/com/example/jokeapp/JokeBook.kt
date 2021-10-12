package com.example.jokeapp

import kotlin.random.Random

data class JokeBook(var currentJoke: String = "") {
    val jokes = listOf(
        "Hoe noem je een koninklijke drol? Een majeschijt.",
        "Jantje bestelt een pizza bij de pizzeria. 'Wil je hem in 4 of 12 stukken?, vraagt de pizzabakker. 'Graag in 4. Jantje, 'want 12 kan ik er echt niet alleen op.'",
        "Wat is het toppunt van positiviteit? In de gevangenis zingen: 'We gaan nog niet naar huis. Nog lange niet, lange niet!'",

    )

    fun getRandomJoke() : String {
        var randomListNumber = Random.nextInt(jokes.size)
        return jokes[randomListNumber]
    }

    fun changeCurrentJoke(){

        var randomListNumber = Random.nextInt(jokes.size)
        if(currentJoke == jokes[randomListNumber])randomListNumber = randomListNumber.plus(1).mod(jokes.size)
        currentJoke = jokes[randomListNumber]
    }
}