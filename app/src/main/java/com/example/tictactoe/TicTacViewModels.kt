package com.example.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TicTacViewModels: ViewModel() {

    var state by mutableStateOf(GameState())
        private set


    fun onActions(gameActions: GameActions) {
        when (gameActions) {
            is GameActions.Rematch -> restart()
            is GameActions.StartGame -> addImageToBox(gameActions.key)
        }
    }

    private fun addImageToBox(key: Int) {
        val updateMap = state.boxMap.toMutableMap()

        if (state.boxMap[key] != BoxType.NONE) {
            return
        }

        //Add Cross or Circle to the possible key
        if (state.boxMap[key] == BoxType.NONE && state.result == null && state.playerTurn == PlayerTurn.CROSS) {
            updateMap[key] = BoxType.CROSS

            state = state.copy(
                playerTurn = PlayerTurn.CIRCLE,
                boxMap = updateMap
            )

        } else if (state.boxMap[key] == BoxType.NONE && state.result == null && state.playerTurn == PlayerTurn.CIRCLE) {
            updateMap[key] = BoxType.CIRCLE

            state = state.copy(
                playerTurn = PlayerTurn.CROSS,
                boxMap = updateMap
            )
        }
        checkResult()

        stopNextTurn()
    }
    private fun checkResult() {
        //ROW CHECK
        if (state.boxMap[1] == state.boxMap[2] && state.boxMap[1] == state.boxMap[3] && state.boxMap[1] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.ROW1
            )
            checkWinner(state.boxMap[1])
        }

        else if (state.boxMap[4] == state.boxMap[5] && state.boxMap[5] == state.boxMap[6] && state.boxMap[4] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.ROW2
            )
            checkWinner(state.boxMap[4])
        }

        else if (state.boxMap[7] == state.boxMap[8] && state.boxMap[8] == state.boxMap[9] && state.boxMap[7] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.ROW3
            )
            checkWinner(state.boxMap[7])
        }

        //COLUMN CHECK
        else if (state.boxMap[1] == state.boxMap[4] && state.boxMap[4] == state.boxMap[7] && state.boxMap[1] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.COlUMN1
            )
            checkWinner(state.boxMap[1])
        }

        else if (state.boxMap[2] == state.boxMap[5] && state.boxMap[5] == state.boxMap[8] && state.boxMap[2] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.COLUMN2
            )
            checkWinner(state.boxMap[2])
        }

        else if (state.boxMap[3] == state.boxMap[6] && state.boxMap[6] == state.boxMap[9] && state.boxMap[3] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.COLUMN3
            )
            checkWinner(state.boxMap[3])
        }

        //DIAGONAL CHECK
        else if (state.boxMap[1] == state.boxMap[5] && state.boxMap[5] == state.boxMap[9] && state.boxMap[1] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.DIAGONAL1
            )
            checkWinner(state.boxMap[1])
        }

        else if (state.boxMap[3] == state.boxMap[5] && state.boxMap[5] == state.boxMap[7] && state.boxMap[3] != BoxType.NONE) {
            state = state.copy(
                result = GameResult.WIN,
                winType = WinType.DIAGONAL2
            )
            checkWinner(state.boxMap[3])
        }

        //DRAW CHECK
        else if (checkDraw()) {
            state = state.copy(
                result = GameResult.DRAW,
                winner = "DRAW"
            )
        }


    }

    private fun stopNextTurn() {
        if (state.result == GameResult.WIN || state.result == GameResult.DRAW) {
            state = state.copy(
                playerTurn = PlayerTurn.NONE
            )
        }
    }

    private fun checkDraw(): Boolean {
        for (value in state.boxMap.values) {
            if (value == BoxType.NONE ) {
                return false
            }
        }
        return true
    }

    private fun checkWinner(boxType: BoxType?) {
        if (boxType == BoxType.CROSS) {
            state = state.copy(
                winner = "CROSS"
            )
        }
        if (boxType == BoxType.CIRCLE) {
            state = state.copy(
                winner = "CIRCLE"
            )
        }
    }

    private fun restart() {
        val newGameMap: MutableMap<Int, BoxType> = state.boxMap.mapValues { BoxType.NONE }.toMutableMap()

        state = state.copy(
            boxMap = newGameMap,
            winType = null,
            result = null,
            playerTurn = PlayerTurn.CROSS,
            winner = ""
        )
    }
}