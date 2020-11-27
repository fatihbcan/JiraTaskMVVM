package com.example.jirataskmvvm.utils

/*fun divideStringForDate(myString: String): String{

}*/

fun getDate(dateStr: String):String {
    val regex = "[^T]*".toRegex()
    return regex.find(dateStr)!!.value.toString()
}