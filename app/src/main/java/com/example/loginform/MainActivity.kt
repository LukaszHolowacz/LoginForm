package com.example.loginform

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_user_name = findViewById<EditText>(R.id.et_user_name)
        val et_password = findViewById<EditText>(R.id.et_password)
        val et_test = findViewById<EditText>(R.id.test)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_submit.setOnClickListener {
            val user_name = et_user_name.text.toString()
            val password = et_password.text.toString()
            val test = et_test.text.toString()

            if(test.length < 1 || password.length < 1 || user_name.length < 1){
                Toast.makeText(applicationContext, "Wypełnij Wszystkie pola!", Toast.LENGTH_LONG).show()
            }
            else if(password==test){
                val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val intent = Intent(this, PoZalogowaniu::class.java)

                editor.apply {
                    putString("username", user_name)
                }.apply()

                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, "Podane hasła nie są takie same!", Toast.LENGTH_LONG).show()
            }
        }
    }
}