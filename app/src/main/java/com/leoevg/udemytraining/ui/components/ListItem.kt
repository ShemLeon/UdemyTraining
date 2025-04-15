package com.leoevg.udemytraining.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleListItem(
    modifier: Modifier,
    number: Int,
    isSelected: Boolean,
    onItemClicked: () -> Unit
){
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp, pressedElevation = 5.dp, focusedElevation = 5.dp),
        modifier = Modifier
            .clickable { onItemClicked() }
            .background(if (isSelected) Color.Black else Color.White)
    ) {
                Text(
                    text = number.toString(),
                    color = if (isSelected) Color.White else Color.Black
                )
            }

}