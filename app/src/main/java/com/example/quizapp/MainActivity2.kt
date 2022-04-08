package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private var name_dis:TextView?=null
    private var corrct_ans:TextView?=null
    private var total_ans:TextView?=null
    private var button:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        name_dis=findViewById(R.id.nameing)
        corrct_ans=findViewById(R.id.crr)
        total_ans=findViewById(R.id.total)

        name_dis?.text=intent.getStringExtra(questionObjects.User_name)
        corrct_ans?.text=intent.getStringExtra(questionObjects.Correct_ans)
        total_ans?.text=intent.getStringExtra(questionObjects.Total_qus)

        button=findViewById(R.id.btn)
        button?.setOnClickListener{
            val intent=Intent(this ,MainActivity::class.java)
            startActivity(intent)
            finish()
        }





    }


}




