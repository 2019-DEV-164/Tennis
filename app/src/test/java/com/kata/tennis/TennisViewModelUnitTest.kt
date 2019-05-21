package com.kata.tennis

import com.kata.tennis.viewmodel.TennisViewModel
import org.junit.Test

import org.junit.Assert.*

class TennisViewModelUnitTest {
    private var tennisViewModel = TennisViewModel()

    @Test
    fun testShouldCheckIfPlayersPointsAreAtLoveForNewGame() {
        assertEquals(0, tennisViewModel.playerOneScore)
        assertEquals(0, tennisViewModel.playerTwoScore)
    }
}
