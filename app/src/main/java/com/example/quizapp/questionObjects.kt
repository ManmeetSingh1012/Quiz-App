package com.example.quizapp

object questionObjects {

    const val User_name:String="user_name"
    const val Correct_ans:String="correct_answer"
    const val Total_qus:String="total_qus"

    fun GetQuestion():ArrayList<Questions>{

        val QuestionList=ArrayList<Questions>()

        val Que1=Questions(
            1,
            "The ratio of width of our National flag to its length is",
            null,
            "3:5",
        	"2:3",
        	"2:4",
        	"3:4",
            2
        )
        QuestionList.add(Que1)

        val Que2=Questions(
            2,
            "Rabindranath Tagore's 'Jana Gana Mana' has been adopted as India's " +
                    "National Anthem. How many stanzas of the said song were adopted ?",
            null,
            "Only the first stanza" ,
            "The whole song",
            "Third and Fourth stanza",
            "First and Second stanza",
            1
        )
        QuestionList.add(Que2)


        val Que3=Questions(
            3,
            "'Dandia' is a popular dance form of",
            null,
            "Punjab",
            "Uttar pradesh",
            "Gujrat",
            "Karnatka",
            3
        )
        QuestionList.add(Que3)


        val Que4=Questions(
            4,
            "The National Anthem of india was first sung in the year",
            null,
            "1911",
            "1912",
            "1947",
            "1919",
            1
        )
        QuestionList.add(Que4)


        val Que5=Questions(
            5,
            "The National Song of India was composed by",
            null,
            "Rabindranath Tagore" ,
            "Bankim Chandra Chatterji",
            "Iqbal",
            "Jai Shankar Prasad",
            2
        )
        QuestionList.add(Que5)

        val Que6=Questions(
            6,
            "This is the flag of which country?",
            R.drawable.fg1_uk,
            "Ireland" ,
            "New Zeland",
            "Uk",
            "Australia",
            3
        )
        QuestionList.add(Que6)

        val Que7=Questions(
            7,
            "This is the flag of which country?",
            R.drawable.fg2_usa,
            "Japan" ,
            "Tokyo",
            "USA",
            "India",
            3
        )
        QuestionList.add(Que7)

        val Que8=Questions(
            8,
            "This is the flag of which country?",
            R.drawable.fg5_belgium,
            "Belgium" ,
            "Germany",
            "Romania",
            "Ireland",
            1
        )
        QuestionList.add(Que8)

        val Que9=Questions(
            9,
            "This is the flag of which country?",
            R.drawable.fg4_lebnanon,
            "Ethiopia" ,
            "Georgia",
            "Lebanon",
            "Uganda",
            3
        )
        QuestionList.add(Que9)


        val Que10=Questions(
            10,
            "This is the flag of which country?",
            R.drawable.fg3_vietnam,
            "Albania" ,
            "China",
            "Myanmar",
            "Vietnam",
            4
        )
        QuestionList.add(Que10)

        return QuestionList
    }


}