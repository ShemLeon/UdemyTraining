package com.leoevg.udemytraining.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleListItem(
    modifier: Modifier = Modifier,
    number: Int,
    isSelected: Boolean,
    onItemClicked: () -> Unit
){
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
            pressedElevation = 5.dp,
            focusedElevation = 5.dp),
        modifier = Modifier
            .clickable { onItemClicked() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.Black else Color.White
        )
    ) {
        Text(
            text = number.toString(),
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 40.sp
         )
    }
}


@Preview
@Composable
fun SimpleListItemPreview(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ){
        SimpleListItem(
            number = 1,
            isSelected = true
        ) { }
        SimpleListItem(
            number = 2,
            isSelected = false
        ) { }
    }
}