package com.example.manjaha.ui.kategori

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manjaha.R
import com.example.manjaha.adapter.ListBukuAdapter
import com.example.manjaha.adapter.ListKategoriAdapter
import com.example.manjaha.model.Buku
import com.example.manjaha.model.GetBuku
import com.example.manjaha.model.GetKategori
import com.example.manjaha.model.Kategori
import com.example.manjaha.retrofit.BukuService
import com.example.manjaha.retrofit.ManjahaConfig
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KategoriFragment : Fragment() {

    private lateinit var kategoriViewModel: KategoriViewModel
    private lateinit var rvKategori : RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        kategoriViewModel =
                ViewModelProvider(this).get(KategoriViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_kategori, container, false)
        rvKategori = root.findViewById(R.id.rvKategori)
        rvKategori.setHasFixedSize(true)

        val request = ManjahaConfig.buildService(BukuService::class.java)
        request.getKategori().enqueue(object : Callback<GetKategori> {
            override fun onResponse(call: Call<GetKategori>, response: Response<GetKategori>) {
                showRecyclerList(response.body()!!.kategori)
            }

            override fun onFailure(call: Call<GetKategori>, t: Throwable) {
                    MaterialAlertDialogBuilder(context!!)
                        .setTitle("Gagal Menyambungkan ke Server").setMessage("${t.message}").setPositiveButton("Ok"){dialog, which ->

                        }.show()
            }

        }
        )
        return root
    }
    private fun showRecyclerList(list : ArrayList<Kategori>) {
        rvKategori.layoutManager = LinearLayoutManager(this.context)
        val listKategoriAdapter = ListKategoriAdapter(list)
        rvKategori.adapter = listKategoriAdapter
    }
}