package com.example.pipeology
import android.content.Intent
import com.google.firebase.firestore.FirebaseFirestore

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pipeology.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var btnSubmit: Button
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener(this)
        binding.btnNext.setOnClickListener{
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit ->{
                //Toast.makeText(this, "Submit button clicked!", Toast.LENGTH_SHORT).show()

                val db = FirebaseFirestore.getInstance()
                val name = findViewById<EditText>(R.id.NameOfUser).text.toString()
                val age = findViewById<EditText>(R.id.AgeOfUser).text.toString()

                val user = hashMapOf(
                    "name" to name,
                    "age" to age
                )
                db.collection("Users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Log.d("FIREBASE", "DocumentSnapshot added with ID: ${documentReference.id}")
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { e ->
                        Log.w("FIREBASE", "Error adding document", e)
                        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
                    }

            }
        }
    }
}