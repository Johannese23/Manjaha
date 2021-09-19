package com.example.manjaha.ui.keranjang

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manjaha.R
import com.example.manjaha.adapter.ListBukuAdapter
import com.example.manjaha.adapter.ListKeranjangAdapter
import com.example.manjaha.auth.LoginActivity
import com.example.manjaha.model.Buku
import com.example.manjaha.model.GetPesanan
import com.example.manjaha.model.Keranjang
import com.example.manjaha.model.Pesanan
import com.example.manjaha.retrofit.BukuService
import com.example.manjaha.retrofit.ManjahaConfig
import com.example.manjaha.ui.checkout.CaraPembayaranActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KeranjangFragment : Fragment() {
    lateinit var  sharedPrefences: SharedPreferences
    private lateinit var rvKeranjang: RecyclerView
    companion object {
        fun newInstance() = KeranjangFragment()
    }

    private lateinit var viewModel: KeranjangViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.keranjang_fragment, container, false )
        sharedPrefences = context!!.getSharedPreferences("User", Context.MODE_PRIVATE)
        if(sharedPrefences.getInt("user", 0)==0){
            val moveWithDataIntent = Intent(context, LoginActivity::class.java)
            startActivity(moveWithDataIntent)
        }
        rvKeranjang = root.findViewById(R.id.rvKeranjang)
        rvKeranjang.setHasFixedSize(true)
        val request = ManjahaConfig.buildService(BukuService::class.java)
        val map = HashMap<String, String>()
        map.put("pembeli", "2")
        request.getKeranjang(map).enqueue(object : Callback<GetPesanan>{
            override fun onResponse(call: Call<GetPesanan>, response: Response<GetPesanan>) {
                Log.e("TAG",response.body()!!.pesanan.size.toString() )
                    showRecyclerList(response.body()!!.pesanan)
            }

            override fun onFailure(call: Call<GetPesanan>, t: Throwable) {
                container?.context?.let {
                    MaterialAlertDialogBuilder(it)
                        .setTitle("Gagal Menyambungkan ke Server").setMessage("${t.message}").setPositiveButton("Ok"){dialog, which ->

                        }.show()}
            }

        })
        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KeranjangViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun showRecyclerList(lists :  ArrayList<Pesanan>) {
        rvKeranjang.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        val listKeranjangAdapter = ListKeranjangAdapter(lists)
        rvKeranjang.adapter = listKeranjangAdapter
    }
}