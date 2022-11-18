package com.example.mse2223

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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


@Composable
fun Rasterlayout(notes : List<Note> ){
    Column {
        notes.forEach { note ->
            create_Colum(note = note)
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