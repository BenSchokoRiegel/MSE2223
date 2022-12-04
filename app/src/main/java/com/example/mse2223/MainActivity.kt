package com.example.mse2223

import android.content.ClipData
import android.graphics.fonts.Font
import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.text.style.StyleSpan
import android.text.SpannableString
import android.text.TextDirectionHeuristic

import android.view.RoundedCorner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mse2223.ui.theme.MSE2223Theme
import com.example.mse2223.ui.theme.Note
import com.example.mse2223.ui.theme.NotePriority
import com.example.mse2223.ui.theme.getStringWithFix
import java.util.Locale.filter
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val liste: List<Note> = getList(50)

        super.onCreate(savedInstanceState)
        setContent {
            MSE2223Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Rasterlayout(liste)
                    //Uebung()
                }
            }
        }
    }
}


@Composable
fun Coloums(notes : List<Note>){

    //List<List<Notes>>

        LazyRow() {


        }
    }


@Composable
fun Uebung(){
    Row( modifier = Modifier
        .border(1.dp, color = Color.Red)
        .padding(10.dp)
    ) {
        Box(){
            Image(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )

        }
        Column() {
                Text(text = "Herald Hide The Pain ",fontWeight = FontWeight.Bold)
                Text(text= "Kotlin is Pain")
            }







    }




}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Rasterlayout(notes : List<Note> ) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3), verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        items((notes.filter{note -> note.priority != NotePriority.ARCHIVED})) { note ->

            var background = Color.Black;

            if (note.priority == NotePriority.DEFAULT) {
                background = Color.Yellow;
            } else if (note.priority == NotePriority.ARCHIVED) {
                background = Color.Green;

            } else {
                background = Color(250, 0, 50);

            }

            Card() {
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
                        Text(note.text,
                        maxLines = 2,
                                overflow = TextOverflow.Ellipsis)

                    }
                    Row() {


                        Text(
                            text = note.priority.toString().makeimportant(),
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                    Row(){
                        //var picture by remember {mutableStateOf}
                    }
                    if (note.hasPicture){
                        Row() {
                            Image(
                                painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null

                            )

                        }
                    }

                }

            }
        }
    }

}


fun String.makeimportant():String {

    return "$this!!!"

}


fun getList(length: Int):List<Note> {
    val note = Note("Bannanen");
    val note2 = Note("apfel")
    val note3 = Note("Schokolade", "250g")
    val tomate = Note("tomate", "250g")
    val  erdbere = Note("erg","st", NotePriority.ARCHIVED)
    val liste: List<Note> = listOf(note, note2, note3,tomate,erdbere)


    val res: MutableList<Note> = mutableListOf()
    val list = listOf("Bannanen", "apfel", "Schokolade","tomate","Erbeere", "Kiwi","Birne")



    for(i in 1..length){

        val enum = NotePriority.values().get(Random.nextInt(0, 3))
        var weight = ""

        if (Random.nextInt(0, 2) == 0) {
            for (j in 0..Random.nextInt(10))
                if (Random.nextInt(0,3) == 0) {
                    weight += "Kotlin is PAIN!!!"
                    continue
                }
                if (Random.nextInt(0,2)==0) {
                    weight += "Why am i so bad at Kolin!!!"
                    continue
                }
                weight += "Either i am too dumb to Kolin or Kotlin is too Dumb for me!!!!!"
        } else{
            weight =  Random.nextInt(0, 2000).toString() + "g"
        }

        val ele =  list.get(Random.nextInt(0,list.size))
        if (Random.nextInt(0, 2) == 0){
            res.add(Note(ele,weight,enum))
        } else {
            res.add(Note(ele,weight,enum,hasPicture = true))
        }

    }

    return res


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
