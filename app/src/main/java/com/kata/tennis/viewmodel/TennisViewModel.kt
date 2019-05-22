package com.kata.tennis.viewmodel

import android.arch.lifecycle.ViewModel
import com.kata.tennis.model.Players

class TennisViewModel : ViewModel() {

    companion object {
        const val POINT_LOVE = "0"
        const val POINT_ONE = "15"
        const val POINT_TWO = "30"
        const val POINT_THREE = "40"
        const val POINT_EQUAL = "All"
        const val MATCH_STATUS_DEUCE = "Deuce"
        const val MATCH_STATUS_ADVANTAGE = "Advantage"
        const val MATCH_STATUS_WON = "Wins"
    }

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
            return playerWithHighestScore() + " " + MATCH_STATUS_WON
        }

        if (playerHasAdvantage()) {
            return MATCH_STATUS_ADVANTAGE + " " + playerWithHighestScore()
        }

        if (isDeuce()) {
            return MATCH_STATUS_DEUCE
        }

        if (playerOnePoints == playerTwoPoints) {
            return convertPointsToScore(playerOnePoints) + " " + POINT_EQUAL
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
            0 -> return POINT_LOVE
            1 -> return POINT_ONE
            2 -> return POINT_TWO
            3 -> return POINT_THREE
        }
        return ""
    }
}