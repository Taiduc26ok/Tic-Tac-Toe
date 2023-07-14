package com.example.tictactoe

data class GameState(
    val result: GameResult? = null,
    val playerTurn: PlayerTurn = PlayerTurn.CROSS,
    val winType: WinType? = null,
    val boxMap: MutableMap<Int, BoxType> = mutableMapOf(
        1 to BoxType.NONE,
        2 to BoxType.NONE,
        3 to BoxType.NONE,
        4 to BoxType.NONE,
        5 to BoxType.NONE,
        6 to BoxType.NONE,
        7 to BoxType.NONE,
        8 to BoxType.NONE,
        9 to BoxType.NONE,
    ),
    val winner: String = ""
)

enum class PlayerTurn {
    CROSS, CIRCLE, NONE
}


