package com.example.android_25_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.e("MYLOG","done3")

        val textView: TextView = findViewById(R.id.textView_main)
        val randomButton: Button = findViewById(R.id.button_random)

        val receivedRandomNumber = intent.getIntExtra("random_number", 0)
        textView.text = receivedRandomNumber.toString()

        randomButton.setOnClickListener {
            val randomNumber = Random.nextInt(0, 15)
            textView.text = randomNumber.toString()
        }

        val resultIntent = Intent()
        resultIntent.putExtra("random_number", textView.text)
        setResult(Activity.RESULT_OK, resultIntent)
    }
}