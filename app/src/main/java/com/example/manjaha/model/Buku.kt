package com.example.manjaha.model

data class Buku(
    val id : Int,
    val judul : String,
    val deskripsi: String,
    val harga : Int,
    val alamat : String,
    val gambar : String,
    val kategori : String,
    val penjual : String
)
data class GetBuku(
    val message : String,
    val buku : ArrayList<Buku>

)