package com.example.digitalhousechat.model

data class Student(
    val name: String,
    val course: String,
    var read: Boolean = false,
) {
}