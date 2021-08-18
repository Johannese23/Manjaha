package com.example.manjaha.ui.kategori

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
import com.example.manjaha.model.Kategori

class KategoriFragment : Fragment() {

    private lateinit var kategoriViewModel: KategoriViewModel
    private lateinit var rvKategori : RecyclerView
    private var list: ArrayList<Kategori> = arrayListOf()
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
        list.add(Kategori(1,"Majalah"))
        list.add(Kategori(1,"Kamus"))
        list.add(Kategori(1,"Pendidikan"))
        list.add(Kategori(1,"Teknik"))
        list.add(Kategori(1,"Bisnis"))
        list.add(Kategori(1,"Manajemen"))
        list.add(Kategori(1,"Komputer dan Teknologi"))
        list.add(Kategori(1,"Pertanian"))
        list.add(Kategori(1,"Hukum"))
        list.add(Kategori(1,"Sejarah"))
        list.add(Kategori(1,"Ensiklopedia"))



        showRecyclerList()
        return root
    }
    private fun showRecyclerList() {
        rvKategori.layoutManager = LinearLayoutManager(this.context)
        val listKategoriAdapter = ListKategoriAdapter(list)
        rvKategori.adapter = listKategoriAdapter
    }
}