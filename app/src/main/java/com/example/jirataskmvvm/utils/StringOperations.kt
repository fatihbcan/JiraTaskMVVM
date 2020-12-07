package com.example.jirataskmvvm.utils


// YYYY-MM-DDT+03:00-HH:MM to only YYYY-MM-DD
fun getDate(dateStr: String): String {
    val regex = "[^T]*".toRegex()
    return regex.find(dateStr)!!.value
}