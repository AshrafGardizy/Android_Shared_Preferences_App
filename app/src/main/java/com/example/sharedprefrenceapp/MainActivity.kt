package com.example.sharedprefrenceapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tvName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialization
        val edInput:EditText = findViewById(R.id.edInput)
        tvName = findViewById(R.id.txtLatestName)
        val btnSave:Button = findViewById(R.id.buttonSave)
        val btnRead:Button = findViewById(R.id.buttonRead)
        //Event for Save Data
        btnSave.setOnClickListener {
            val enteredName:String = edInput.text.toString()
            saveToPreference(enteredName)
        }

        //Even for Read Data
        btnRead.setOnClickListener {
            readData()
        }

    }

    //Save Data to SharedPreferences
    private fun saveToPreference(enteredName: String) {

        val sharedPrefrence:SharedPreferences = getSharedPreferences("UserName",
        MODE_PRIVATE)
        val edit:SharedPreferences.Editor = sharedPrefrence.edit()
        edit.putString("name",enteredName)
        edit.commit()
    }

    //Read Data from SharedPrefrences

    private fun readData()
    {
        val sharedPrefrence:SharedPreferences = getSharedPreferences("UserName",
            MODE_PRIVATE)
        val value:String? = sharedPrefrence.getString("name","")
        tvName.setText(value)
    }

}