package com.syncmob.guessmynumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.syncmob.guessmynumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var number: Int = 5
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        printTheQuestion()

    }

    fun clickDownArrow(view: View) {
        if (number == 5) {
            guessMyNumber(3)
        } else if (number == 3) {
            guessMyNumber(2)
        } else if (number == 2) {
            guessMyNumber(1)
        } else if (number == 8) {
            guessMyNumber(7)
        } else if (number == 7) {
            guessMyNumber(6)
        }
    }

    fun clickSuccess(view: View) {
        binding.questionTextview.visibility = View.INVISIBLE
        binding.resultTextview.visibility = View.VISIBLE
        binding.resultTextview.text =
            String.format(resources.getString(R.string.yourNumberIs, number))
    }

    fun clickUpArrow(view: View) {
        if (number == 3) {
            guessMyNumber(3)
        } else if (number == 5) {
            guessMyNumber(8)
        } else if (number == 8) {
            guessMyNumber(9)
        } else if (number == 9) {
            guessMyNumber(10)
        }

    }

    fun clickResetButton(view: View) {
        binding.questionTextview.visibility = View.VISIBLE
        binding.resultTextview.visibility = View.INVISIBLE
        number = 5
        printTheQuestion()
    }

    fun printTheQuestion() {
        binding.questionTextview.text =
            String.format(resources.getString(R.string.is_your_number, number))
    }

    fun guessMyNumber(myNumber: Int) {
        number = myNumber
        printTheQuestion()
    }


}