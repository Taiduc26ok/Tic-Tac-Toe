package com.example.tictactoe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxSquare(
    modifier: Modifier = Modifier,
    borderSize : Dp = 1.dp,
    borderColor: Color = Color.Gray,
    onclick: () -> Unit,
    state: GameState,
    key: Int
) {
    Box(
        modifier = Modifier
            .border(
                BorderStroke(borderSize, borderColor),
            )
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onclick()
            }
            .then(modifier),
    ) {
        when (state.boxMap[key]) {
            BoxType.CROSS -> PutCross()
            BoxType.CIRCLE -> PutCircle()
            else -> Image(painter = painterResource(id = R.drawable.none), contentDescription = null )
        }
    }
}

@Composable
fun PutCross() {
    Image(painter = painterResource(id = R.drawable.crossimage), contentDescription = null)
}

@Composable
fun PutCircle() {
    Image(painter = painterResource(id = R.drawable.circle), contentDescription = null )
}