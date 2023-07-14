package com.example.tictactoe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun DrawWinLine(winType: WinType?) {
    Canvas(modifier = Modifier
        .fillMaxSize()
    ) {
        val startPointHorizontal: Float = size.width / 6
        val startPointVertical: Float = size.height / 6

        val endPointHorizontal: Float = size.width * 5 / 6
        val endPointVertical: Float = size.height * 5 / 6

        val centralPointHorizontal: Float = size.width / 2
        val centralPointVertical: Float = size.height / 2

        when (winType) {
            WinType.DIAGONAL1 -> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(startPointHorizontal, startPointVertical),
                end = Offset(endPointHorizontal, endPointVertical)
            )
            WinType.DIAGONAL2 -> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(endPointHorizontal, startPointVertical),
                end = Offset(startPointHorizontal, endPointVertical)
            )
            WinType.COlUMN1 -> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(startPointHorizontal, startPointVertical),
                end = Offset(startPointHorizontal, endPointVertical)
            )
            WinType.COLUMN2 -> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(centralPointHorizontal, startPointVertical),
                end = Offset(centralPointHorizontal,endPointVertical)
            )
            WinType.COLUMN3 -> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(endPointHorizontal, startPointVertical),
                end = Offset(endPointHorizontal, endPointVertical)
            )
            WinType.ROW1-> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(startPointHorizontal, startPointVertical),
                end = Offset(endPointHorizontal, startPointVertical)
            )
            WinType.ROW2-> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(startPointHorizontal, centralPointVertical),
                end = Offset(endPointHorizontal, centralPointVertical)
            )
            WinType.ROW3-> drawLine(
                color = Color.Black,
                strokeWidth = 15f,
                start = Offset(startPointHorizontal, endPointVertical),
                end = Offset(endPointHorizontal, endPointVertical)
            )
            else -> {}
        }
    }
}