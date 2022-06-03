package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var buttonClickedToast : Toast? = null
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }

    }

    fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    fun getRandomDiceImage(): Int {
        buttonClickedToast?.cancel()
        buttonClickedToast = Toast.makeText(this, "çok iyi çalkalıyorsun beybimsu ", Toast.LENGTH_SHORT)
        buttonClickedToast?.show()
        val randomInt = (1..6).random()

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun reset() {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

}