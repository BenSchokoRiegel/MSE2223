package com.example.mse2223.ui.theme

enum class NotePriority {
    IMPORTANT, DEFAULT, ARCHIVED
}

fun NotePriority.toString(): String{
    if (this.equals(NotePriority.IMPORTANT)){
        return "IMPORTANT" + "!!!!"
    } else {
        return this.name + "s"
    }
}


fun NotePriority.getStringWithFix() : String{
    if (this.equals(NotePriority.IMPORTANT)){
        return (this.toString() + "!!!!")
    } else {
        return this.toString()
    }
}
/**
class Note constructor(val title: String, val text: String, val priority: NotePriority) {
    constructor(title: String) : this(title, "", NotePriority.DEFAULT)
    constructor(title: String, text: String) : this(title, text, NotePriority.DEFAULT)
}
*/
class Note (val title: String, val text: String, val priority: NotePriority, val hasPicture : Boolean) {



    constructor(title: String) : this(title, "", NotePriority.DEFAULT,false)
    constructor(title: String, text: String) : this(title, text, NotePriority.DEFAULT,false)
    constructor(title: String, text: String,priority: NotePriority) : this(title, text, priority,false)
    //constructor(title: String, text: String,priorit) : this(title, text, NotePriority.DEFAULT)



}