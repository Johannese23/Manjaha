package com.example.manjaha.ui.akun

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manjaha.R
import com.example.manjaha.auth.LoginActivity

class Akun : Fragment() {
    lateinit var  sharedPrefences: SharedPreferences

    companion object {
        fun newInstance() = Akun()
    }

    private lateinit var viewModel: AkunViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val root =inflater.inflate(R.layout.akun_fragment, container, false)

        return root;

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AkunViewModel::class.java)
        sharedPrefences = context!!.getSharedPreferences("User", Context.MODE_PRIVATE)
        if(sharedPrefences.getInt("user", 0)==0){
            val moveWithDataIntent = Intent(context, LoginActivity::class.java)
            context?.startActivity(moveWithDataIntent)
        }
        // TODO: Use the ViewModel
    }

}