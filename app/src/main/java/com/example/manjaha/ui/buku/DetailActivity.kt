package com.example.manjaha.ui.buku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.manjaha.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tambahKeranjang : Button = findViewById(R.id.tambah_keranjang)
        tambahKeranjang.setOnClickListener {
            Toast.makeText(applicationContext,"Buku telah ditambahkan kedalam keranjang",Toast.LENGTH_SHORT).show()
        }
    }
}