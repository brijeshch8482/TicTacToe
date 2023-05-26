package com.example.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.winner_dialoge.*

class GameActivity : AppCompatActivity() {
    var turnCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun buClick(view: View){
        var cellId = 0
        val buSelected = view as Button

        when(buSelected.id){
            R.id.bu1 ->
                cellId = 1
            R.id.bu2 ->
                cellId = 2
            R.id.bu3 ->
                cellId = 3
            R.id.bu4 ->
                cellId = 4
            R.id.bu5 ->
                cellId = 5
            R.id.bu6 ->
                cellId = 6
            R.id.bu7 ->
                cellId = 7
            R.id.bu8 ->
                cellId = 8
            R.id.bu9 ->
                cellId = 9
        }
//        Log.d("buClick",buSelected.id.toString())
//        Log.d("buClick : cellID",cellId.toString())

        playGame(cellId, buSelected)
    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    private fun playGame(cellId: Int, buSelected: Button){
        if(activePlayer == 1){
            buSelected.text = "x"
            buSelected.setBackgroundResource(R.drawable.playeronebox)
            player1.add(cellId)
            turnCount++
            activePlayer = 2
        }else{
            buSelected.text = "0"
            buSelected.setBackgroundResource(R.drawable.playertwobox)
            player2.add(cellId)
            turnCount++
            activePlayer = 1
        }

        buSelected.isEnabled = false
        checkWinner()
    }

    private fun checkWinner(){
        var winner = -1

//        Row 1 winner
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

//        Row 2 winner
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

//        Row 3 winner
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

//        column 1 winner
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //        column 2 winner
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //        column 3 winner
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //   diagonal 1 winner
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        //        diagonal 2 winner
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }


        when (winner) {
            1 -> {
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(false)
                dialog.setContentView(R.layout.winner_dialoge)
                dialog.winner.text = "Player 1 win the Game"

                dialog.exit.setOnClickListener{
                    val intent = Intent(this,StartActivity::class.java)
                    startActivity(intent)
                }

                dialog.playagain.setOnClickListener{
                    val intent = Intent(this, GameActivity::class.java)
                    finish()
                    startActivity(intent)
                }
                dialog.show()

            }
            2 -> {
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(false)
                dialog.setContentView(R.layout.winner_dialoge)
                dialog.winner.text = "Player 2 win the Game"

                dialog.exit.setOnClickListener{
                    val intent = Intent(this,StartActivity::class.java)
                    startActivity(intent)
                }

                dialog.playagain.setOnClickListener{
                    val intent = Intent(this, GameActivity::class.java)
                    finish()
                    startActivity(intent)
                }
                dialog.show()


            }

        }
        if(turnCount == 9 ) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialoge)
            dialog.winner.text = "Draw the Game"

            dialog.exit.setOnClickListener{
                val intent = Intent(this,StartActivity::class.java)
                startActivity(intent)
            }

            dialog.playagain.setOnClickListener{
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()


        }



//        if(winner == 1){
//            Toast.makeText(this, "Player 1 win the Game",Toast.LENGTH_LONG).show()
//        }else if(winner == 2){
//            Toast.makeText(this,"Player 2 win the Game", Toast.LENGTH_LONG).show()
//        }
    }

}