package com.example.manjaha.ui.buku

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manjaha.R
import com.example.manjaha.adapter.ListBukuAdapter
import com.example.manjaha.adapter.ListBukuAllAdapter
import com.example.manjaha.model.Buku
import com.example.manjaha.model.GetBuku
import com.example.manjaha.retrofit.BukuService
import com.example.manjaha.retrofit.ManjahaConfig
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllBookActivity : AppCompatActivity() {
    private lateinit var rvBuku :  RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val request = ManjahaConfig.buildService(BukuService::class.java)
        setContentView(R.layout.activity_all_book)
        rvBuku = findViewById(R.id.rvBukus)
        val category : Int = intent.getIntExtra("category",0)
        val extraTitle : String? = intent.getStringExtra("title")
        val title : TextView =  findViewById(R.id.title);
        title.setText(extraTitle)
        val callBook = request.getBukuByGenre(category,2);
        callBook.enqueue(object : Callback<GetBuku> {
            override fun onResponse(
                call: Call<GetBuku>,
                response: Response<GetBuku>
            ) {

                showRecyclerBook(response.body()!!.buku)
            }

            override fun onFailure(call: Call<GetBuku>, t: Throwable) {

                    MaterialAlertDialogBuilder(applicationContext)
                        .setTitle("Gagal Menyambungkan ke Server").setMessage("${t.message}").setPositiveButton("Ok"){dialog, which ->

                        }.show()
            }
        })
    }
    private fun showRecyclerBook(list: ArrayList<Buku> ) {
        val gridLayoutManager =
            GridLayoutManager(applicationContext, 3)
        rvBuku.layoutManager = gridLayoutManager

        val gridHeroAdapter = ListBukuAllAdapter(list)
        rvBuku.adapter = gridHeroAdapter
    }
}