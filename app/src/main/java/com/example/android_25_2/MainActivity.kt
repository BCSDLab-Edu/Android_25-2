package com.example.android_25_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

        val textView: TextView = findViewById(R.id.textView_main)

        val toastButton: Button = findViewById(R.id.button_toast)
        toastButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show()
        }

        val countButton: Button = findViewById(R.id.button_count)
        countButton.setOnClickListener {
            val currentText1 = textView.text.toString().toInt()
            val newCount = currentText1 + 1
            textView.text = newCount.toString()
        }

        val randomButton: Button = findViewById(R.id.button_random)
        randomButton.setOnClickListener {
            val randomNumber = Random.nextInt(0, 15)
            launchSecondActivity(randomNumber)
        }
    }

    private fun launchSecondActivity(randomNumber: Int) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("random_number", randomNumber)
        launcher.launch(intent)
    }
}