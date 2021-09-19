package com.example.manjaha.model

data class Kategori(val id: Int, val nama : String)
data class GetKategori(val message:String,  val kategori : ArrayList<Kategori>)
