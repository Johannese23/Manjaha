 package com.example.manjaha

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


 class MainActivity : AppCompatActivity() {
    lateinit var  appbar : MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appbar = findViewById(R.id.tolbar)
        setSupportActionBar(appbar)
//        getActionBar()?.setDisplayHomeAsUpEnabled(true);
//        getActionBar()?.setHomeButtonEnabled(true)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        var data : ArrayList<String> = ArrayList()

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_keranjang,R.id.navigation_akun))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.setTitle(null)



    }
     override fun onCreateOptionsMenu(menu: Menu): Boolean {
         val inflater: MenuInflater = menuInflater
         inflater.inflate(R.menu.appbar_menu, menu)
         return true
     }
}