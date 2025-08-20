package com.leoevg.udemytraining.screens._7_LazyRow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.udemytraining.navigation.NavigationPath
import com.leoevg.udemytraining.ui.components.SimpleListItem
import com.leoevg.udemytraining.ui.theme.Blue
import com.leoevg.udemytraining.ui.theme.UdemyTrainingTheme

@Composable
fun ExampleLazyRow(
    navigate: (NavigationPath) -> Unit = {}
){
    var currentSelectedItem by remember { mutableIntStateOf(5) }
    var list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            items(list) { listItem ->
                SimpleListItem(
                    number = listItem,
                    isSelected = currentSelectedItem == listItem
                ) {
                    currentSelectedItem = listItem
                }
            }
        }


        Button(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.8f)
                .padding(top = 160.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = {
                navigate(NavigationPath.StartSealed)
            }
        ){
            Text(
                text = "Back to main",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun LazyRowPreview(){
    UdemyTrainingTheme() {
        ExampleLazyRow()
    }
}

