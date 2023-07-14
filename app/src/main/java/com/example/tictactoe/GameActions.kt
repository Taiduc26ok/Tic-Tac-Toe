package com.example.tictactoe

sealed class GameActions {
    data class StartGame(val key: Int) : GameActions()
    object Rematch: GameActions()
}
