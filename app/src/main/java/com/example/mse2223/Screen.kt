package com.example.mse2223

sealed class Screen(val route: String){
    object NotesOverView : Screen("NotesOverView")
    object CreateNote : Screen("CreateNote")




}

