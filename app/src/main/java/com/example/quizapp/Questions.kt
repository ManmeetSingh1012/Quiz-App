package com.example.quizapp

import android.media.Image

data class Questions(
    var id:Int,
    var question:String,
    var img:Int?,
    var optionOne:String,
    var optiontwo: String,
    var optionThree:String,
    var optionfour :String,
    var correctAnswer:Int
)
