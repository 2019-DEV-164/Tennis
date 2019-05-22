package com.kata.tennis

import com.kata.tennis.model.Players
import com.kata.tennis.viewmodel.TennisViewModel
import org.junit.Test

import org.junit.Assert.*

class TennisViewModelUnitTest {
    private var tennisViewModel = TennisViewModel()

    @Test
    fun testShouldCheckIfPlayersPointsAreAtLoveForNewGame() {
        assertEquals("0 all", tennisViewModel.getMatchScore())
    }

    @Test
    fun testPlayerOneWinsFirstBall() {
        tennisViewModel.playerOneScores()
        assertEquals("15 - 0", tennisViewModel.getMatchScore())
    }

    @Test
    fun testPlayerTwoWinsFirstBall() {
        tennisViewModel.playerTwoScores()
        assertEquals("0 - 15", tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfPlayerOneHasScoredFirstTwoPoints() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        assertEquals("30 - 0", tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfPlayerTwoHasScoredFirstThreePoints() {
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        assertEquals("0 - 40", tennisViewModel.getMatchScore())
    }

    @Test
    fun testIfBothPlayersScoredOnePointEach() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        assertEquals("15 all", tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnAllInScoreIfBothPlayersScoresEqualPoints() {
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        assertEquals("30 all", tennisViewModel.getMatchScore())
    }

    @Test
    fun testShouldReturnDeuceIfBothPlayersScoresThreePointsEach() {
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        assertEquals("Deuce", tennisViewModel.getMatchScore())
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
        assertEquals("Advantage" + " " + Players.PLAYER_ONE_NAME,
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
        assertEquals(Players.PLAYER_TWO_NAME + " " + "Wins",
            tennisViewModel.getMatchScore())
    }
}
