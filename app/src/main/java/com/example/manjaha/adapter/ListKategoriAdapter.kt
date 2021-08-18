package com.example.manjaha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.manjaha.R
import com.example.manjaha.model.Kategori

class ListKategoriAdapter(private  val listKategori : ArrayList<Kategori>) : RecyclerView.Adapter<ListKategoriAdapter.ListKategoriHolder>() {
    inner class  ListKategoriHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val namaKategori = itemView.findViewById(R.id.nama_kategori) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKategoriHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kategori, parent, false)
        return ListKategoriHolder(view)
    }

    override fun onBindViewHolder(holder: ListKategoriHolder, position: Int) {
        holder.namaKategori.setText(listKategori.get(position).nama)
    }

    override fun getItemCount(): Int {
        return listKategori.size
    }
}