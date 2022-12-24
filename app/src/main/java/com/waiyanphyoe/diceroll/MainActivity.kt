package com.waiyanphyoe.diceroll

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    var totalPoints = 100
    var betAmount = 0
    lateinit var txtTotalPoint: TextView
    lateinit var edtBetAmount: EditText
    //lateinit var imageDice: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgDice: ImageView = findViewById(R.id.imgDice)
        val btnRoll: Button = findViewById(R.id.btnRoll)

        txtTotalPoint = findViewById(R.id.totalPoint)
        edtBetAmount = findViewById(R.id.betAmount)

        btnRoll.setOnClickListener {
            rollDice(imgDice)
        }
    }

    private fun rollDice(diceImg: ImageView){
        if(totalPoints <= 0){

        }
        else{
            betAmount = edtBetAmount.text.toString().toInt()

            val randomInt = Random().nextInt(6) + 1
            val drawableResource = when(randomInt){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImg.setImageResource(drawableResource)
            when(randomInt){
                in 1..2 -> totalPoints -= betAmount
                in 4..5 -> totalPoints += betAmount
                6 -> totalPoints += betAmount * 2
            }
            txtTotalPoint.text = totalPoints.toString()
        }
    }
}