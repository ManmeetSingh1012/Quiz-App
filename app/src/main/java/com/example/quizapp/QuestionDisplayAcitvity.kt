package com.example.quizapp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class QuestionDisplayAcitvity : AppCompatActivity() ,  View.OnClickListener{

    private var qus:TextView?=null
    private var image:ImageView?=null
    private var prgbar:ProgressBar?=null
    private var prog_no:TextView?=null
    private var one:TextView?=null
    private var two:TextView?=null
    private var three:TextView?=null
    private var four:TextView?=null
    private var button:TextView?=null
    private var mcorrectanswers=0
    private var Questionslist:ArrayList<Questions>?=null
    private var current:Int=0
    private var selected:Int=0
    private var musername:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_display_acitvity)




        qus=findViewById(R.id.qus)
        image=findViewById(R.id.image)
        prgbar=findViewById(R.id.progress)
        prog_no=findViewById(R.id.prg_no)
        one=findViewById(R.id.first)
        two=findViewById(R.id.sec)
        three=findViewById(R.id.third)
        four=findViewById(R.id.fourth)
        button=findViewById(R.id.button)

        one?.setOnClickListener(this)
        two?.setOnClickListener(this)
        three?.setOnClickListener(this)
        four?.setOnClickListener(this)
        button?.setOnClickListener(this)

       musername=intent.getStringExtra(questionObjects.User_name)


        Questionslist=questionObjects.GetQuestion()

        displayquest()
    }

    private fun displayquest() {

        defaultoptionView()
        val ques: Questions = Questionslist!!.get(current)
        qus?.text=ques.question
        prgbar?.progress=current+1
                prog_no?.text="${current+1}/${prgbar?.max}"
        one?.text=ques.optionOne
        two?.text=ques.optiontwo
        three?.text=ques.optionThree
        four?.text=ques.optionfour
        ques.img?.let { image?.setImageResource(it) }

        if(current-1 == Questionslist?.size!!)
        {
            button?.text="Finish"
        }
        else
        {
            button?.text="Submit"
        }

    }

    private fun defaultoptionView()
    {
        val options=ArrayList<TextView>()
        one?.let { options.add(it) }
        two?.let { options.add(it) }
        three?.let { options.add(it) }
        four?.let { options.add(it) }

        for(options in options)
        {
            options.typeface= Typeface.DEFAULT
            options.background=ContextCompat.getDrawable(
                this,
                R.drawable.defalult_option
            )

        }

    }

    private fun slectedoptionview(textView: TextView,selectedoptionNum:Int)
    {
        defaultoptionView()
        selected=selectedoptionNum
        //textView.setTextColor(Color.parseColor("#669900"))
        //textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background=ContextCompat.getDrawable(
            this,
            R.drawable.on_clicked
        )

    }


    private fun answers(answers:Int,drawable:Int)
    {
        when(answers)
        {
            1 ->{
                one!!.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }

            2 ->{
                two!!.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }

            3 ->{
                three!!.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }

            4 ->{
                four!!.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.first->one?.let{slectedoptionview(it,1)}
            R.id.sec->two?.let{slectedoptionview(it,2)}
            R.id.third->three?.let{slectedoptionview(it,3)}
            R.id.fourth->four?.let{slectedoptionview(it,4)}
            R.id.button->
            {
                if(selected==0)
                {
                    current++
                    when{
                        current<Questionslist!!.size->{
                            displayquest()
                        }

                        else->{
                            val intent=Intent(this,MainActivity2::class.java)
                            intent.putExtra(questionObjects.Correct_ans,mcorrectanswers.toString())
                            intent.putExtra(questionObjects.User_name,musername)
                            intent.putExtra(questionObjects.Total_qus,Questionslist!!.size.toString())
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else
                {
                    val crans=Questionslist!!.get(current)
                    if(crans.correctAnswer == selected)
                    {
                        mcorrectanswers++
                    }
                    else
                    {
                        answers(selected,R.drawable.in_correct_options)
                    }
                    answers(crans.correctAnswer,R.drawable.correct_option)

                    button?.text="Go To Next Question"
                    selected=0
                }
            }
        }
    }
}



