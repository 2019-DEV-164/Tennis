package com.kata.tennis

import com.kata.tennis.model.Players
import com.kata.tennis.viewmodel.TennisViewModel
import org.junit.Test

import org.junit.Assert.*

class TennisViewModelUnitTest {
    private var tennisViewModel = TennisViewModel()

    @Test
    fun testShouldCheckIfPlayersPointsAreAtLoveForNewGame() {
        assertEquals(TennisViewModel.POINT_LOVE + " " + TennisViewModel.POINT_EQUAL,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testPlayerOneWinsFirstBall() {
        recordPoints(1, 0)
        assertEquals(TennisViewModel.POINT_ONE + " - " + TennisViewModel.POINT_LOVE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testPlayerTwoWinsFirstBall() {
        recordPoints(0, 1)
        assertEquals(TennisViewModel.POINT_LOVE + " - " + TennisViewModel.POINT_ONE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfPlayerOneHasScoredFirstTwoPoints() {
        recordPoints(2, 0)
        assertEquals(TennisViewModel.POINT_TWO + " - " + TennisViewModel.POINT_LOVE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfPlayerTwoHasScoredFirstThreePoints() {
        recordPoints(0, 3)
        assertEquals(TennisViewModel.POINT_LOVE + " - " + TennisViewModel.POINT_THREE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfBothPlayersScoredOnePointEach() {
        recordPoints(1, 1)
        assertEquals(TennisViewModel.POINT_ONE + " " + TennisViewModel.POINT_EQUAL,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnAllInScoreIfBothPlayersScoresEqualPoints() {
        recordPoints(2, 2)
        assertEquals(TennisViewModel.POINT_TWO + " " + TennisViewModel.POINT_EQUAL,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnDeuceIfBothPlayersScoresThreePointsEach() {
        recordPoints(3, 3)
        assertEquals(TennisViewModel.MATCH_STATUS_DEUCE, tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnAdvantageIfAnyPlayerScoresAPointAfterDeuce() {
        recordPoints(4, 3)
        assertEquals(TennisViewModel.MATCH_STATUS_ADVANTAGE + " " + Players.PLAYER_ONE_NAME,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnWinIfAnyPlayerScoresAPointAfterTheirAdvantage() {
        recordPoints(3, 5)
        assertEquals(Players.PLAYER_TWO_NAME + " " + TennisViewModel.MATCH_STATUS_WON,
            tennisViewModel.getMatchScore())
    }

    private fun recordPoints(playerOne: Int, playerTwo: Int){
        for(i in 1..playerOne){
            tennisViewModel.playerOneScores()
        }
        for (i in 1..playerTwo){
            tennisViewModel.playerTwoScores()
        }
    }
}
