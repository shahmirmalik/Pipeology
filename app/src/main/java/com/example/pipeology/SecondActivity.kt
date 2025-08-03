package com.example.pipeology

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pipeology.databinding.ActivityMainBinding
import com.example.pipeology.databinding.ActivitySecond2Binding

class SecondActivity : AppCompatActivity() {

    lateinit var secondBinding: ActivitySecond2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondBinding = ActivitySecond2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(secondBinding.root)

        secondBinding.btnBack.setOnClickListener {
            val intent = Intent(this@SecondActivity,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
