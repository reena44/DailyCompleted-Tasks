package com.example.dailycompletedtask

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExtensionFunction :AppCompatActivity(){
    var skills : String = "null"
    fun printMySkills() {
        print(skills)
    }
}
fun main(args: Array<String>) {
    var  a1 = ExtensionFunction()
    a1.skills = "JAVA"
    //a1.printMySkills()

    var  a2 = ExtensionFunction()
    a2.skills = "SQL"
    //a2.printMySkills()

    var  a3 = ExtensionFunction()
    a3.skills = a1.addMySkills(a2)
    a3.printMySkills()
}
fun ExtensionFunction.addMySkills(a:ExtensionFunction):String{
    var a4 = ExtensionFunction()
    a4.skills = this.skills + " " +a.skills
    Toast.makeText(this,a.skills,Toast.LENGTH_LONG).show()
    return a4.skills
}