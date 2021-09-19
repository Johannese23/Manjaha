package com.example.manjaha.ui.pengumuman

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PengumumanViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Pengumuman Masih Dalam Tahap Pengembangan"
    }
    val text: LiveData<String> = _text
}