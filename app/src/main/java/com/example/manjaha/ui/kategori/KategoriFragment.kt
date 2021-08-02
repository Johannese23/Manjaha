package com.example.manjaha.ui.kategori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manjaha.R

class KategoriFragment : Fragment() {

    private lateinit var kategoriViewModel: KategoriViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        kategoriViewModel =
                ViewModelProvider(this).get(KategoriViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_kategori, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        kategoriViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}