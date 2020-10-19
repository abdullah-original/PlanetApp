package com.example.planetapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

    override fun onStart() {
        super.onStart()
        println(("onStart called"))
    }

    override fun onResume() {
        super.onResume()
        println("onResume called")
    }

    override fun onPause() {
        super.onPause()
        println("onPause called")
    }


    override fun onStop() {
        super.onStop()
        println("onStop called")
    }


    override fun onDestroy() {
        println("onDestroy called")
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart called")
    }


    fun printName() {
        println("Hello world! Abdullah here")
    }




}