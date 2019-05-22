package com.kata.tennis.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kata.tennis.R
import com.kata.tennis.viewmodel.TennisViewModel
import kotlinx.android.synthetic.main.activity_tennis.*

class TennisActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tennisViewModel: TennisViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tennis)

        tennisViewModel = TennisViewModel()
        point_to_player_one.setOnClickListener(this)
        point_to_player_two.setOnClickListener(this)

        updateScoreOnUi()
    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.point_to_player_one -> {
                tennisViewModel.playerOneScores()
                updateScoreOnUi()
            }

            R.id.point_to_player_two -> {
                tennisViewModel.playerTwoScores()
                updateScoreOnUi()
            }
        }
    }

    private fun updateScoreOnUi() {
        match_score.text = tennisViewModel.getMatchScore()
    }
}
