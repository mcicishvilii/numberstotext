package com.example.numberstotext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.et_number)
        val button = findViewById<Button>(R.id.btn_transform)
        val textView = findViewById<TextView>(R.id.tv_result)


        button.setOnClickListener {
            val x = editText.editableText.toList()

            var value1 = ""
            var value2 = ""
            var value3 = ""

            when (x[0]){
                '1' -> value1 = "ას"
                '2' -> value1 = "ორას"
                '3' -> value1 = "სამას"
                '4' -> value1 = "ოთხას"
                '5' -> value1 = "ხუთას"
                '6' -> value1 = "ექვსას"
                '7' -> value1 = "შვიდას"
                '8' -> value1 = "რვაას"
                '9' -> value1 = "ცხრაას"
            }

            when (x[1]){
                '2' -> value2 = "ოცდა"

                '4' -> value2 = "ორმოცდა"

                '6' -> value2 = "სამოცდა"

                '8' -> value2 = "ოთხმოცდა"

            }

            if      (x[2] == '1') value3 = "ერთი"
            else if (x[2] == '2') value3 = "ორი"
            else if (x[2] == '3') value3 = "სამი"
            else if (x[2] == '4') value3 = "ოთხი"
            else if (x[2] == '5') value3 = "ხუთი"
            else if (x[2] == '6') value3 = "ექვსი"
            else if (x[2] == '7') value3 = "შვიდი"
            else if (x[2] == '8') value3 = "რვა"
            else if (x[2] == '9') value3 = "ცხრა"

            else if (x[1] == '3' && x[2] == '2') value3 = "თორმეტი"
            else if (x[1] == '3' && x[2] == '3') value3 = "ცამეტი"
            else if (x[1] == '4' && x[2] == '4') value3 = "თოთხმეტი"




             textView.text = ("$value1 ${value2}${value3}")
        }
    }
}
