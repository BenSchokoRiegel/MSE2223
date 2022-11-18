package com.example.mse2223

import android.content.ClipData
import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mse2223.ui.theme.MSE2223Theme
import com.example.mse2223.ui.theme.Note
import com.example.mse2223.ui.theme.NotePriority

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val note = Note("Bannanen");
        val note2 = Note("apfel")
        val note3 = Note("Schokolade", "250g")
        val liste: List<Note> = listOf(note, note2, note3)

        super.onCreate(savedInstanceState)
        setContent {
            MSE2223Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Rasterlayout(liste)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Rasterlayout(notes : List<Note> ) {
    LazyVerticalGrid(cells = GridCells.Fixed(3),verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(notes) { note ->

            var background = Color.Black;

            if (note.priority == NotePriority.DEFAULT){
                background = Color.Yellow;
            } else if (note.priority == NotePriority.ARCHIVED){
                background = Color.Yellow;
            } else {
                background = Color.Yellow;
            }

            Card {
                Column() {
                    Row(){
                        Text(note.title)
                    }
                    Row(){
                        if(note.text != ""){
                            Text(note.text)
                        }
                    }
                    Row(){
                        Text(note.priority.toString())
                    }



                }

            }
        }


    }
}





@Composable
fun create_Colum(note : Note, modifier: Modifier = Modifier){
    if (note.text == ""){
        Row{
            Text(note.title)

        }
    } else {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(2.dp)
                .background(Color.Yellow, RoundedCornerShape(4.dp))
                .padding(2.dp))
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

fun createRow(note: Note) {

}
