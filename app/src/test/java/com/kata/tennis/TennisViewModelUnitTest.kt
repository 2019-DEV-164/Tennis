package com.kata.tennis

import com.kata.tennis.viewmodel.TennisViewModel
import org.junit.Test

import org.junit.Assert.*

class TennisViewModelUnitTest {
    private var tennisViewModel = TennisViewModel()

    @Test
    fun testShouldCheckIfPlayersPointsAreAtLoveForNewGame() {
        assertEquals(0, tennisViewModel.playerOnePoints)
        assertEquals(0, tennisViewModel.playerTwoPoints)
    }

    @Test
    fun testPlayerOneWinsFirstBall() {
        tennisViewModel.playerOneScores()
        assertEquals("15", tennisViewModel.checkPlayerOneScore())
    }

    @Test
    fun testPlayerTwoWinsFirstBall() {
        tennisViewModel.playerTwoScores()
        assertEquals("15", tennisViewModel.checkPlayerTwoScore())
    }

    @Test
    fun testIfPlayerOneHasScoredFirstTwoPoints(){
        tennisViewModel.playerOneScores()
        tennisViewModel.playerOneScores()
        assertEquals("30", tennisViewModel.checkPlayerOneScore())
    }

    @Test
    fun testIfPlayerTwoHasScoredFirstThreePoints(){
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        tennisViewModel.playerTwoScores()
        assertEquals("40", tennisViewModel.checkPlayerTwoScore())
    }
}
