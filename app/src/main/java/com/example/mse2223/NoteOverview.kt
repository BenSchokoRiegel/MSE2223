@file:OptIn(ExperimentalFoundationApi::class)

package com.example.mse2223

import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mse2223.ui.theme.MSE2223Theme


@Composable
fun NotesOverView(notes: List<Note>, navController: NavController) {

    MSE2223Theme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = { Topbar() },
            bottomBar = { BottomAppBar(backgroundColor = Color.Red) { Text("Click FloatingAction to add Random elements ") } },
            floatingActionButton = {
                //FloatingActionButton(onClick = { navController.navigate(Screen.CreateNote.route) }
                FloatingActionButton(onClick = { navController.navigate(Screen.CreateNote.route) }
                ) {
                    /* FAB content */
                }
            }

        ) {

            Rasterlayout(notes)


        }


    }

}


@Composable
fun AllCards(notes: List<Note>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3), verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        items((notes.filter { note -> note.priority != NotePriority.ARCHIVED })) { note ->

            var background = Color.Black;

            if (note.priority == NotePriority.DEFAULT) {
                background = Color.Yellow;
            } else if (note.priority == NotePriority.ARCHIVED) {
                background = Color.Green;

            } else {
                background = Color(250, 0, 50);

            }

            var maxLines = remember {
                mutableStateOf(1)
            }

            Card(
                modifier = Modifier.clickable {
                    if (maxLines.value == 1) {
                        maxLines.value = Integer.MAX_VALUE
                    } else {
                        maxLines.value = 1
                    }


                }

            ) {
                Column(
                    modifier = Modifier
                        .background(background)
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    Row() {
                        Text(note.title)
                    }
                    Row() {
                        Text(
                            note.text,
                            maxLines = maxLines.value,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                    Row() {


                        Text(
                            text = note.priority.toString().makeimportant(),
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                    Row(
                        modifier = Modifier
                            .height(55.dp)
                            .fillMaxSize()
                    ) {
                        if (note.hasPicture) {

                            Image(

                                painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxSize(),
                            )

                        }
                    }

                }

            }
        }
    }


}
