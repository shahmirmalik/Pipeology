package com.example.pipeology

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var btnSubmit: Button
    lateinit var name1: TextView
    lateinit var age: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnSubmit = findViewById(R.id.btnSubmit)
    }

    override fun onClick(v: View?) {
        var nameOfUser = name1.text.toString()
        var age = name1.text
        when(v?.id){
            R.id.btnSubmit ->{}
        }
    }
}