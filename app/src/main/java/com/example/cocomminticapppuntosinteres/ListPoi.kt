package com.example.cocomminticapppuntosinteres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView

class ListPoi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poi)

        //val -> variable no se puede modificar
        //var -> variable se puede modificar.

        val sendButton = findViewById<CardView>(R.id.cardView1)

        sendButton.setOnClickListener {
            Log.d("MainActivity", "Tag en la card")
        }
    }
}