package com.example.manjaha.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manjaha.R
import com.example.manjaha.adapter.ListBukuAdapter
import com.example.manjaha.model.Buku
import com.example.manjaha.model.GetBuku
import com.example.manjaha.retrofit.BukuService
import com.example.manjaha.retrofit.ManjahaConfig
import com.example.manjaha.ui.buku.AllBookActivity
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var rvBukuBaru: RecyclerView
    private lateinit var rvBukuKomik: RecyclerView
    private lateinit var rvBukuPengembangan: RecyclerView

    private var list: ArrayList<Buku> = arrayListOf()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

////        val textView: TextView = root.findViewById(R.id.text_home)
////        homeViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
        rvBukuBaru = root.findViewById(R.id.baru_upload_home)
        rvBukuBaru.setHasFixedSize(true)
        rvBukuKomik = root.findViewById(R.id.komik_home)
        rvBukuKomik.setHasFixedSize(true)
        rvBukuPengembangan = root.findViewById(R.id.pengembangan_home)
        rvBukuPengembangan.setHasFixedSize(true)
        val request = ManjahaConfig.buildService(BukuService::class.java)
        val callNewBook = request.getBukuTerbaru(2)
        val barushimmerLayout : ShimmerFrameLayout = root.findViewById(R.id.barushimmerLayout)
        val komikshimmerLayout : ShimmerFrameLayout = root.findViewById(R.id.komikshimmerLayout)
        val pengembanganshimmerLayout : ShimmerFrameLayout = root.findViewById(R.id.pengembanganshimmerLayout)
        callNewBook.enqueue(object : Callback<GetBuku> {
            override fun onResponse(call: Call<GetBuku>, response: Response<GetBuku>) {
                barushimmerLayout.setVisibility(View.GONE);
                showRecyclerList(rvBukuBaru, response.body()!!.buku)
                val calKomikBook = request.getBukuByGenre(3,2);
                calKomikBook.enqueue(object  : Callback<GetBuku> {
                    override fun onResponse(call: Call<GetBuku>, response: Response<GetBuku>) {
                        komikshimmerLayout.setVisibility(View.GONE);
                        showRecyclerList(rvBukuKomik, response.body()!!.buku)
                        val callPengembanganBook = request.getBukuByGenre(11,2);
                        callPengembanganBook.enqueue(object : Callback<GetBuku> {
                            override fun onResponse(
                                call: Call<GetBuku>,
                                response: Response<GetBuku>
                            ) {
                                pengembanganshimmerLayout.setVisibility(View.GONE);
                                showRecyclerList(rvBukuPengembangan, response.body()!!.buku)
                            }

                            override fun onFailure(call: Call<GetBuku>, t: Throwable) {
                                container?.context?.let {
                                    MaterialAlertDialogBuilder(it)
                                        .setTitle("Gagal Menyambungkan ke Server").setMessage("${t.message}").setPositiveButton("Ok"){dialog, which ->

                                        }.show()}
                            }
                        })

                    }

                    override fun onFailure(call: Call<GetBuku>, t: Throwable) {
                        container?.context?.let {
                            MaterialAlertDialogBuilder(it)
                                .setTitle("Gagal Menyambungkan ke Server").setMessage("${t.message}").setPositiveButton("Ok"){dialog, which ->

                                }.show()}
                    }
                })
            }

            override fun onFailure(call: Call<GetBuku>, t: Throwable) {
                container?.context?.let {
                    MaterialAlertDialogBuilder(it)
                        .setTitle("Gagal Menyambungkan ke Server").setMessage("${t.message}").setPositiveButton("Ok"){dialog, which ->

                        }.show()}
            }
        })
        showRecyclerList(rvBukuKomik,list)
        showRecyclerList(rvBukuPengembangan,list)
        val lihatSemuaTerbaru : TextView = root.findViewById(R.id.lihat_semua_terbaru)
        lihatSemuaTerbaru.setOnClickListener {
            val moveIntent = Intent(root.context, AllBookActivity::class.java)
            moveIntent.putExtra("category", 0);
            moveIntent.putExtra("title", "Baru Upload");
            startActivity(moveIntent)
        }
        val lihatSemuaKategori : TextView = root.findViewById(R.id.lihat_semua_kategori)
        val lihatSemuaKomik : TextView = root.findViewById(R.id.lihat_semua_komik)
        lihatSemuaKomik.setOnClickListener {
            val moveIntent = Intent(root.context, AllBookActivity::class.java)
            moveIntent.putExtra("category", 3);
            moveIntent.putExtra("title", "Kategori Komik");
            startActivity(moveIntent)
        }
        val lihatSemuaPengembangan : TextView = root.findViewById(R.id.lihat_semua_pengembangan)
        lihatSemuaPengembangan.setOnClickListener {
            val moveIntent = Intent(root.context, AllBookActivity::class.java)
            moveIntent.putExtra("category", 11);
            moveIntent.putExtra("title", "Kategori Pengembangan Diri");
            startActivity(moveIntent)
        }

        return root
    }
    private fun showRecyclerList(rv : RecyclerView,lists :  ArrayList<Buku>) {
        rv.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)
        val listBukuAdapter = ListBukuAdapter(lists)
        rv.adapter = listBukuAdapter
    }
}