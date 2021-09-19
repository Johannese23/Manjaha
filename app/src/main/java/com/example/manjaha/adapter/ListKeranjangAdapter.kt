package com.example.manjaha.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.manjaha.R
import com.example.manjaha.model.Buku
import com.example.manjaha.model.Kategori
import com.example.manjaha.model.Keranjang
import com.example.manjaha.model.Pesanan
import com.example.manjaha.ui.buku.AllBookActivity
import com.example.manjaha.ui.checkout.CheckOutActivity
import com.google.android.material.button.MaterialButton
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ListKeranjangAdapter(private  val listKeranjang : ArrayList<Pesanan>) : RecyclerView.Adapter<ListKeranjangAdapter.ListKeranjangHolder>() {
    inner class  ListKeranjangHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val judul = itemView.findViewById(R.id.judul_keranjang) as TextView
        val harga = itemView.findViewById(R.id.harga_keranjang) as TextView
        val bayar = itemView.findViewById(R.id.bayar_keranjang) as MaterialButton
        var hapus = itemView.findViewById(R.id.hapus_keranjang) as ImageButton
        val gambar = itemView.findViewById(R.id.gambar_keranjang) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKeranjangHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_keranjang, parent, false)
        return ListKeranjangHolder(view)
    }

    override fun onBindViewHolder(holder: ListKeranjangHolder, position: Int) {
        val pesanan : Pesanan = listKeranjang.get(position)
        holder.judul.setText(pesanan.judul)
        holder.harga.setText("Rp" + NumberFormat.getNumberInstance(Locale.US).format(pesanan.hargaBuku))
        Glide.with(holder.itemView.context).load(pesanan.gambar).apply(RequestOptions().override(250,350)).into(holder.gambar)
        holder.bayar.setOnClickListener {
            val moveIntent = Intent(holder.judul.context, CheckOutActivity::class.java)
            holder.judul.context.startActivity(moveIntent)
        }
    }
    override fun getItemCount(): Int {
        return listKeranjang.size
    }
}