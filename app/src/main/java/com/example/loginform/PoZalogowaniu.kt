package com.example.loginform

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PoZalogowaniu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_po_zalogowaniu)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", null)
        val textBox = findViewById<TextView>(R.id.powitanie)

        textBox.text = "Witaj! " + username
    }
}