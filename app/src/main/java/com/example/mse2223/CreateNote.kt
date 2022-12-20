package com.example.mse2223

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController

@Composable

fun CreateNote(navController: NavController) {


    Column {
        var title by rememberSaveable { mutableStateOf("") }
        var text by rememberSaveable { mutableStateOf("") }
        var priority by rememberSaveable { mutableStateOf("TODO") }
        TextField(value = title, onValueChange = { title = it })
        TextField(value = text, onValueChange = { text = it })
        TextField(value = priority, onValueChange = { priority = it })

        /* Button(onClick = {
             navController.navigate(Screen.NotesOverView.route)
         }) { Text(text = "Go Back") }
         */

        Button(onClick = {
            val note = Note(title = title, text = text)
            navController.currentBackStackEntry?.savedStateHandle?.set("newNote", note)
            navController.navigate(Screen.NotesOverView.route + "/$title" + "/$text")

        }) { Text(text = "Save Data") }
    }
}

