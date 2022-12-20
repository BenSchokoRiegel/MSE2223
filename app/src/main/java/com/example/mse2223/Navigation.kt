package com.example.mse2223

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {


    var liste by remember {
        mutableStateOf(listOf<Note>())
    }


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.NotesOverView.route) {
        composable(route = Screen.NotesOverView.route) {
            NotesOverView(notes = liste, navController)
        }
        composable(route = Screen.CreateNote.route) {
            CreateNote(navController)
        }

        composable(
            route = Screen.NotesOverView.route + "/{title}/{text}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = "unknown"
                },
                navArgument("text") {
                    type = NavType.StringType
                    defaultValue = "idfk"
                }
            )
        )
        {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Note>("newNote")
            // Hier weiß ich nicht wie ich das machen soll -> wird unendlich oft aufgerufen
            //liste = updateList(liste,it.arguments?.getString("title").toString(),it.arguments?.getString("text").toString())

            if (result != null){
                liste = liste + result
                navController.previousBackStackEntry?.savedStateHandle?.remove<Note>("newNote")
            }

            NotesOverView(
                // updatet dann nicht die Liste!!!!
                //notes = updateList(liste,it.arguments?.getString("title").toString(),it.arguments?.getString("text").toString()),
                notes = liste,
                navController = navController
            )

        }


    }
}

fun updateList(notes:List<Note>, title:String, text: String):List<Note>{
 // könnte hier dirty den Code abfangen das es nichts doppelt gibt aber das wäre auch nicht optimal
    return notes + Note(title,text)
}

