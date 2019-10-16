package com.philippeloctaux.intragek

fun downloadStudentImage(autologin: String, student: String) {
    val url = "$autologin/file/userprofil/profilview/$student.jpg"
    println(url)
}
