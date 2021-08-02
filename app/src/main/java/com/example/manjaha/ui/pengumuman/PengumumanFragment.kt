package com.example.manjaha.ui.pengumuman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manjaha.R

class PengumumanFragment : Fragment() {

    private lateinit var pengumumanViewModel: PengumumanViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        pengumumanViewModel =
                ViewModelProvider(this).get(PengumumanViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pengumuman, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        pengumumanViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}