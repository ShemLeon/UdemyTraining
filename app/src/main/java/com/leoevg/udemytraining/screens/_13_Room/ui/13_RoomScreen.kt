package com.leoevg.udemytraining.screens._13_Room.ui

import android.app.LauncherActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leoevg.udemytraining.navigation.NavigationPath


@Composable
fun RoomScreen(
    roomScreenViewModel: RoomScreenViewModel = viewModel(factory = RoomScreenViewModel.factory),
    navigate: (NavigationPath) -> Unit = {}
){
    val itemsList = roomScreenViewModel.itemsList.collectAsState(initial = emptyList())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = roomScreenViewModel.newText.value,
                onValueChange = {
                    roomScreenViewModel.newText.value = it
                },
                label = {
                    Text(text = "Name...")
                },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            IconButton(
                onClick = {
                    roomScreenViewModel.insertItem()
                }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(itemsList.value){  item ->
                ListItem(
                    item,{
                    roomScreenViewModel.nameEntity = it
                    roomScreenViewModel.newText.value = it.name
                },
                {
                    roomScreenViewModel.deleteItem(it)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoomScreenPreview(){
    RoomScreen()
}