package com.example.jirataskmvvm.utils

fun getDate(dateStr: String):String {
    val regex = "[^T]*".toRegex()
    return regex.find(dateStr)!!.value
}