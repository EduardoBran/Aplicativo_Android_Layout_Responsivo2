package com.luizeduardobrandao.layoutresponsivo2.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizeduardobrandao.layoutresponsivo2.R
import com.luizeduardobrandao.layoutresponsivo2.databinding.ActivityMainBinding
import com.luizeduardobrandao.layoutresponsivo2.helper.BannerAds

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1) Infla o layout e seta a ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2) Configura a Toolbar (binding.toolbarMain) como ActionBar da Activity
        setSupportActionBar(binding.toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // inicializa SDK
        BannerAds.initialize(this)

        // carrega o banner no container da view binding
        BannerAds.loadBanner(this, binding.frameBanner)
    }
}