package com.example.manjaha.ui.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.manjaha.R
import com.example.manjaha.ui.buku.DetailActivity

class CheckOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        val bayar : Button = findViewById(R.id.bayar)
        bayar.setOnClickListener {
            val moveWithDataIntent = Intent(applicationContext, CaraPembayaranActivity::class.java)
            startActivity(moveWithDataIntent)
        }
    }
}