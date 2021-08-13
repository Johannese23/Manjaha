package com.example.manjaha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.manjaha.R
import com.example.manjaha.model.Buku

class ListBukuAdapter(private  val listBuku : ArrayList<Buku>) : RecyclerView.Adapter<ListBukuAdapter.ListBukuHolder>(){

    inner class ListBukuHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var gambarBuku:ImageView = itemView.findViewById(R.id.gambar_buku_item)
        var judulBuku : TextView = itemView.findViewById(R.id.judul_buku_item)
        var hargaBuku : TextView = itemView.findViewById(R.id.harga_buku_item)
        var lokasiBuku : TextView = itemView.findViewById(R.id.lokasi_buku_item)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBukuHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_buku, parent, false)
        return ListBukuHolder(view)
    }

    override fun onBindViewHolder(holder: ListBukuHolder, position: Int) {
        val buku : Buku = listBuku.get(position)
        Glide.with(holder.itemView.context).load(buku.gambar).apply(RequestOptions().override(250,350)).into(holder.gambarBuku)
        holder.judulBuku.setText(buku.judul)
        holder.hargaBuku.setText("Rp." + buku.harga.toString())
        holder.lokasiBuku.setText(buku.lokasi)
    }

    override fun getItemCount(): Int {
        return listBuku.size
    }
}