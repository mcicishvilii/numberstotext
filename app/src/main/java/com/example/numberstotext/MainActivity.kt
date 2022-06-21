package com.example.numberstotext

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.et_number)
        val button = findViewById<Button>(R.id.btn_transform)
        val textView = findViewById<TextView>(R.id.tv_result)
        val checker = findViewById<TextView>(R.id.checker)


        button.setOnClickListener {
            val number = editText.editableText
            val trimmed = number.chunked(1).toMutableList()
            val trimmedp = trimmed.map {it}.toTypedArray()

            val map11to20 = mutableMapOf(
                "1" to "თერთმეტი",
                "2" to "თორმეტი",
                "3" to "ცამეტი",
                "4" to "თოთხმეტი",
                "5" to "თხუთმეტი",
                "6" to "თექვსმეტი",
                "7" to "ჩვიდმეტი",
                "8" to "თვრამეტი",
                "9" to "ცხრამეტი")

            val map1to10 = mutableMapOf(
                "1" to "ერთი",
                "2" to "ორი",
                "3" to "სამი",
                "4" to "ოთხი",
                "5" to "ხუთი",
                "6" to "ექვსი",
                "7" to "შვიდი",
                "8" to "რვა",
                "9" to "ცხრა")

            val map10to90 = mutableMapOf(
                "2" to "ოცდა",
                "3" to "ოცდა",
                "4" to "ორმოცდა",
                "5" to "ორმოცდა",
                "6" to "სამოცდა",
                "7" to "სამოცდა",
                "8" to "ოთხმოცდა",
                "9" to "ოთხმოცდა")

            val map10to90Freestanding = mutableMapOf(
                "1" to "ათი",
                "2" to "ოცი",
                "3" to "ოცდაათი",
                "4" to "ორმოცი",
                "5" to "ორმოცდაათი",
                "6" to "სამოცი",
                "7" to "სამოცდაათი",
                "8" to "ოთხმოცი",
                "9" to "ოთხმოცდაათი")

            val map100to1000 = mutableMapOf(
                "1" to "ას",
                "2" to "ორას",
                "3" to "სამას",
                "4" to "ოთხას",
                "5" to "ხუთას",
                "6" to "ექვსას",
                "7" to "შვიდას",
                "8" to "რვაას",
                "9" to "ცხრაას")

            when (trimmedp.size) {
                1 -> {

                    textView.text = ("${map1to10[trimmedp[0]]}")
                    textView.setTextColor(Color.WHITE)

                }
                2 -> {

                    if(trimmedp[0] == "2" || trimmedp[0] == "4" || trimmedp[0] == "6" || trimmedp[0] == "8" ) {
                        textView.text = ("${map10to90[trimmedp[0]]}${map1to10[trimmedp[1]]}")
                    }
                    else if(trimmedp[0] == "3" || trimmedp[0] == "5" || trimmedp[0] == "7" || trimmedp[0] == "9" ){
                        textView.text = ("${map10to90[trimmedp[0]]}${map11to20[trimmedp[1]]}")
                    }
                    else if (trimmedp[0] == "1"){
                        textView.text = ("${map11to20[trimmedp[1]]}")
                    }

                    if ((trimmedp[1] == "0") && (trimmedp[0] == "1" || trimmedp[0] == "2" || trimmedp[0] == "4" ||
                                trimmedp[0] == "6" || trimmedp[0] == "8" || trimmedp[0] == "3" || trimmedp[0] == "5" || trimmedp[0] == "7" || trimmedp[0] == "9"  )){
                        textView.text = ("${map10to90Freestanding[trimmedp[0]]}")
                    }
                    textView.setTextColor(Color.WHITE)

                }

                3 -> {

                    if(trimmedp[2] == "0" && trimmedp[1] == "1"){
                        textView.text = ("${map100to1000[trimmedp[0]]} ათი")
                        checker.text = " 1 if"
                    }
                    else if((trimmedp[2] == "0")){
                        textView.text = ("${map100to1000[trimmedp[0]]} ${map10to90Freestanding[trimmedp[1]]}")
                        checker.text = " 2 if"
                    }
                    else if(trimmedp[1] == "2" || trimmedp[1] == "4" || trimmedp[1] == "6" || trimmedp[1] == "8" ) {
                        textView.text = ("${map100to1000[trimmedp[0]]} ${map10to90[trimmedp[1]]}${map1to10[trimmedp[2]]}")
                        checker.text = " 3 if"
                    }
                    else if(trimmedp[1] == "3" || trimmedp[1] == "5" || trimmedp[1] == "7" || trimmedp[1] == "9" ){
                        textView.text = ("${map100to1000[trimmedp[0]]} ${map10to90[trimmedp[1]]}${map11to20[trimmedp[2]]}")
                        checker.text = " 4 if"

                    }
                    else if(trimmedp[1] == "0"){
                        textView.text = ("${map100to1000[trimmedp[0]]} ${map1to10[trimmedp[2]]}")
                        checker.text = " 5 if"
                    }

                    else if(trimmedp[1] == "1"){
                        textView.text = ("${map100to1000[trimmedp[0]]} ${map11to20[trimmedp[2]]}")
                        checker.text = " 6 if"
                    }

                    if ((trimmedp[2] == "0") && (trimmedp[1] == "0") && (trimmedp[0] == "1" || trimmedp[0] == "2" || trimmedp[0] == "4" ||
                                trimmedp[0] == "6" || trimmedp[0] == "8" || trimmedp[0] == "3" || trimmedp[0] == "5" || trimmedp[0] == "7" || trimmedp[0] == "9"  )){
                        textView.text = ("${map100to1000[trimmedp[0]]}ი")
                    }
                    textView.setTextColor(Color.WHITE)
                }
            }
            if (trimmedp.size > 3){
                textView.text = "dont use more then 3 digits!"
                textView.setTextColor(Color.RED)
            }
            if (trimmedp.isEmpty()){
                textView.text = "please enter the number"
                textView.setTextColor(Color.RED)
            }
        }
    }
}
