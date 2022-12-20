@file:OptIn(ExperimentalFoundationApi::class)

package com.example.mse2223

import androidx.compose.ui.graphics.Color
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mse2223.ui.theme.MSE2223Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Navigation()
        }
    }

  /*  override fun onCreate(savedInstanceState: Bundle?) {

        var liste by mutableStateOf(listOf<Note>())

        liste += getList(10)

        super.onCreate(savedInstanceState)

        setContent {
            MSE2223Theme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { Topbar() },
                    bottomBar = { BottomAppBar(backgroundColor = Color.Red) { Text("Click FloatingAction to add Random elements ") } },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { liste = liste + getList(5) }
                        ) {
                            /* FAB content */
                        }
                    }
                ) {
                       Rasterlayout(liste)

                }
            }
        }
    }
   */
}



@Composable
fun Topbar() {
    TopAppBar(
        modifier = Modifier.padding(4.dp, 4.dp),
        backgroundColor = Color.Red,
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "NotizApp",
                textAlign = TextAlign.Center
            )
        }

    )
}




@Composable
fun Uebung() {
    Row(
        modifier = Modifier
            .border(1.dp, color = Color.Red)
            .padding(10.dp)
    ) {
        Box() {
            Image(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )

        }
        Column() {
            Text(text = "Herald Hide The Pain ", fontWeight = FontWeight.Bold)
            Text(text = "Kotlin is Pain")
        }
    }

}


@Composable
fun Rasterlayout(notes: List<Note>) {
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


fun String.makeimportant(): String {

    return "$this!!!"

}


fun getList(length: Int): List<Note> {
    val note = Note("Bannanen");
    val note2 = Note("apfel")
    val note3 = Note("Schokolade", "250g")
    val tomate = Note("tomate", "250g")
    val erdbere = Note("erg", "st", NotePriority.ARCHIVED)
    val liste: List<Note> = listOf(note, note2, note3, tomate, erdbere)


    val res: MutableList<Note> = mutableListOf()
    val list = listOf("Bannanen", "apfel", "Schokolade", "tomate", "Erbeere", "Kiwi", "Birne")



    for (i in 1..length) {

        val enum = NotePriority.values().get(Random.nextInt(0, 3))
        var weight = ""

        if (Random.nextInt(0, 3) > 0) {
            for (j in 0..Random.nextInt(10))
                if (Random.nextInt(0, 3) == 0) {
                    weight += "Kotlin is PAIN!!!"
                    continue
                }
            if (Random.nextInt(0, 2) == 0) {
                weight += "Why am i so bad at Kolin!!!"
                continue
            }
            weight += "Either i am too dumb to Kolin or Kotlin is too Dumb for me!!!!!"
        } else {
            weight = Random.nextInt(0, 2000).toString() + "g"
        }

        val ele = list.get(Random.nextInt(0, list.size))
        if (Random.nextInt(0, 2) == 0) {
            res.add(Note(ele, weight, enum))
        } else {
            res.add(Note(ele, weight, enum, hasPicture = true))
        }

    }

    return res


}


@Composable
fun create_Colum(note: Note, modifier: Modifier = Modifier) {
    if (note.text == "") {
        Row {
            Text(note.title)

        }
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(2.dp)
                .background(Color.Yellow, RoundedCornerShape(4.dp))
                .padding(2.dp)
        )
        {
            Text(note.title)
            Text(note.text)
        }

    }


}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MSE2223Theme {
        Greeting("Android")
    }
}


