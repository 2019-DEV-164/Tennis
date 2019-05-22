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
        tennisViewModel.playerOneScores()
        assertEquals(TennisViewModel.POINT_ONE + " - " + TennisViewModel.POINT_LOVE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testPlayerTwoWinsFirstBall() {
        tennisViewModel.playerTwoScores()
        assertEquals(TennisViewModel.POINT_LOVE + " - " + TennisViewModel.POINT_ONE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfPlayerOneHasScoredFirstTwoPoints() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        assertEquals(TennisViewModel.POINT_TWO + " - " + TennisViewModel.POINT_LOVE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfPlayerTwoHasScoredFirstThreePoints() {
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        assertEquals(TennisViewModel.POINT_LOVE + " - " + TennisViewModel.POINT_THREE,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfBothPlayersScoredOnePointEach() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        assertEquals(TennisViewModel.POINT_ONE + " " + TennisViewModel.POINT_EQUAL,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnAllInScoreIfBothPlayersScoresEqualPoints() {
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        assertEquals(TennisViewModel.POINT_TWO + " " + TennisViewModel.POINT_EQUAL,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnDeuceIfBothPlayersScoresThreePointsEach() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        assertEquals(TennisViewModel.MATCH_STATUS_DEUCE, tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnAdvantageIfAnyPlayerScoresAPointAfterDeuce() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerOneScores()
        assertEquals(TennisViewModel.MATCH_STATUS_ADVANTAGE + " " + Players.PLAYER_ONE_NAME,
            tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnWinIfAnyPlayerScoresAPointAfterTheirAdvantage() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        assertEquals(Players.PLAYER_TWO_NAME + " " + TennisViewModel.MATCH_STATUS_WON,
            tennisViewModel.getMatchScore())
    }
}
