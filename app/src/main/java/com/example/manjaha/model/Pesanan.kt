package com.example.manjaha.model

data class Pesanan(val id:Int,val judul:String, val hargaBuku: Int,val status:Int,val alamat:String,  val gambar:String)
data class GetPesanan(val message:String,  val pesanan : ArrayList<Pesanan>)
