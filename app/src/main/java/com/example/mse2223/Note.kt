package com.example.mse2223.ui.theme

enum class NotePriority {
    IMPORTANT, DEFAULT, ARCHIVED
}
/**
class Note constructor(val title: String, val text: String, val priority: NotePriority) {
    constructor(title: String) : this(title, "", NotePriority.DEFAULT)
    constructor(title: String, text: String) : this(title, text, NotePriority.DEFAULT)
}
*/
class Note (val title: String, val text: String, val priority: NotePriority) {
    constructor(title: String) : this(title, "", NotePriority.DEFAULT)
    constructor(title: String, text: String) : this(title, text, NotePriority.DEFAULT)
}