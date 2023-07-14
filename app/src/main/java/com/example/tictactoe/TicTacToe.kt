package com.example.tictactoe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicTocToe(
    modifier: Modifier = Modifier,
    onAction: (GameActions) -> Unit,
    state: GameState
) {
    Box(modifier = modifier) {
        //All Text Fields
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(vertical = 60.dp),
            text = "Tic Tac Toe",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontFamily = FontFamily(Font(R.font.wide)
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(
                    horizontal = 30.dp,
                    vertical = 170.dp
                ),
            text = "WINNER: ${state.winner}",
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.wide))
            )

        val turn: String = when (state.playerTurn) {
            PlayerTurn.CROSS -> "CROSS"
            PlayerTurn.CIRCLE -> "CIRCLE"
            PlayerTurn.NONE -> ""
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(
                    horizontal = 30.dp,
                    vertical = 170.dp
                ),
            text = "NEXT TURN: $turn",
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.wide))
        )

        //Rematch Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 40.dp, horizontal = 150.dp)
                .background(Color.LightGray)
                .border(3.dp, Color.Black)
                .clickable { onAction(GameActions.Rematch) }
                ) {
            Image(painter = painterResource(
                id = R.drawable.rematch),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    )
        }

        //Squares Box
        Box(
            modifier = Modifier
                .height(350.dp)
                .width(350.dp)
                .padding(10.dp)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(40.dp)),
            ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(1))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 1
                    )
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(2))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 2
                    )
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(3))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 3
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(4))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 4
                    )
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(5))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 5
                    )
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(6))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 6
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(7))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 7
                    )
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(8))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 8
                    )
                    BoxSquare(
                        onclick = {onAction(GameActions.StartGame(9))},
                        modifier = Modifier.background(Color.White),
                        state = state,
                        key = 9
                    )
                }
            }

            DrawWinLine(winType = state.winType)
        }
    }
}