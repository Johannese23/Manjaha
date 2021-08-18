package com.example.manjaha.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manjaha.R
import com.example.manjaha.adapter.ListBukuAdapter
import com.example.manjaha.model.Buku

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
        list.add( Buku(11,"NORA BARRET |THE KING OF .....",15000,"JAKARTA UTARA",R.drawable.b1))
        list.add( Buku(11,"THE HYPOCRITE WORLD",40000,"SUMATERA UTARA",R.drawable.b2))
        list.add( Buku(12,"PROMISE",35000,"SUMATERA UTARA",R.drawable.b3))
        list.add( Buku(13,"MORE MIRACLE THAN ....",35000,"SUMATERA UTARA",R.drawable.b4))


        showRecyclerList(rvBukuBaru)
        showRecyclerList(rvBukuKomik)
        showRecyclerList(rvBukuPengembangan)

        return root
    }
    private fun showRecyclerList(rv : RecyclerView) {
        rv.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)
        val listBukuAdapter = ListBukuAdapter(list)
        rv.adapter = listBukuAdapter
    }
}