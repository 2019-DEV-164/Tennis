package com.kata.tennis.viewmodel

import android.arch.lifecycle.ViewModel
import com.kata.tennis.model.Players

class TennisViewModel : ViewModel() {

    var playerOnePoints = 0
    var playerTwoPoints = 0

    fun playerOneScores() {
        playerOnePoints += 1
    }

    fun playerTwoScores() {
        playerTwoPoints += 1
    }

    fun getMatchScore(): String {

        if(playerHasWon()){
            return playerWithHighestScore() + " " + "Wins"
        }

        if (playerHasAdvantage()) {
            return "Advantage" + " " + playerWithHighestScore()
        }

        if (isDeuce()) {
            return "Deuce"
        }

        if (playerOnePoints == playerTwoPoints) {
            return convertPointsToScore(playerOnePoints) + " all"
        }

        return convertPointsToScore(playerOnePoints) + " - " + convertPointsToScore(playerTwoPoints)
    }

    private fun playerWithHighestScore(): String {
        if(playerOnePoints > playerTwoPoints){
            return Players.PLAYER_ONE_NAME
        } else{
            return Players.PLAYER_TWO_NAME
        }
    }

    private fun playerHasWon(): Boolean {
        if (playerOnePoints >= 4 && playerOnePoints >= playerTwoPoints + 2) {
            return true
        }
        if (playerTwoPoints >= 4 && playerTwoPoints >= playerOnePoints + 2) {
            return true
        }
        return false
    }

    private fun playerHasAdvantage(): Boolean {
        if (playerOnePoints >= 4 && playerOnePoints == playerTwoPoints + 1) {
            return true
        }
        if (playerTwoPoints >= 4 && playerTwoPoints == playerOnePoints + 1) {
            return true
        }
        return false
    }

    private fun isDeuce(): Boolean {
        return playerOnePoints >= 3 && playerOnePoints == playerTwoPoints
    }

    private fun convertPointsToScore(points: Int): String {
        when (points) {
            0 -> return "0"
            1 -> return "15"
            2 -> return "30"
            3 -> return "40"
        }
        return ""
    }
}