package com.example.jirataskmvvm.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/*fun divideStringForDate(myString: String): String{

}*/

fun getDate(dateStr: String):String {
    val regex = "[^T]*".toRegex()
    return regex.find(dateStr)!!.value.toString()
}