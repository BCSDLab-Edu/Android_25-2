package com.example.android_25_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class ListItem(val name: String)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText: EditText = findViewById(R.id.edit_text)
        val addButton : Button = findViewById(R.id.button_add)
        val itemList = mutableListOf<ListItem>()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = NameAdapter(itemList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val name = editText.text.toString()
            if (name.isNotEmpty()){
                itemList.add(ListItem(name))
                adapter.notifyItemInserted(itemList.size -1)
                editText.text.clear()
            }
        }
    }
}