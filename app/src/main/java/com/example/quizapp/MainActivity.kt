package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton:Button=findViewById(R.id.btn_start)
        val textfield:EditText=findViewById(R.id.edtext)
        startButton.setOnClickListener {
            if(textfield.text.isEmpty())
            {
                Toast.makeText(this,"Error name is not entered",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent=Intent(this,QuestionDisplayAcitvity::class.java)
                intent.putExtra(questionObjects.User_name,textfield.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}