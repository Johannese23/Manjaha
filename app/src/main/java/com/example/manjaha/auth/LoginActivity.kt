package com.example.manjaha.auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.manjaha.MainActivity
import com.example.manjaha.R
import com.example.manjaha.ui.checkout.CaraPembayaranActivity

class LoginActivity : AppCompatActivity() {
    lateinit var  sharedPrefences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val masuk : Button = findViewById(R.id.btn_masuk)
        sharedPrefences = getSharedPreferences("User", Context.MODE_PRIVATE)
        masuk.setOnClickListener {
            val editor :SharedPreferences.Editor = sharedPrefences.edit()
            editor.putInt("user", 2);
            editor.apply()
            val moveWithDataIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(moveWithDataIntent)
        }
    }
}