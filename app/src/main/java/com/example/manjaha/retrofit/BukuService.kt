package com.example.manjaha.retrofit

import com.example.manjaha.model.GetBuku
import com.example.manjaha.model.GetKategori
import com.example.manjaha.model.GetPesanan
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BukuService {
    @GET("buku/new/{id}")
    fun getBukuTerbaru(@Path("id")id : Int) : Call<GetBuku>
    @GET("buku/kategori/{category}/{id}")
    fun getBukuByGenre(@Path("category")category : Int,@Path("id")id : Int) : Call<GetBuku>
    @GET("kategori")
    fun getKategori() : Call<GetKategori>
    @POST("keranjang")
    fun getKeranjang(@Body map : HashMap<String, String>) : Call<GetPesanan>
}