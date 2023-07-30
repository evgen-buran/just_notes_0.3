package com.example.justnotes03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.justnotes03.databinding.ActivityMainBinding
import com.example.justnotes03.utils.APP_ACTIVITY

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    lateinit var navController: NavController
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(APP_ACTIVITY, R.id.navHost)
        toolbar = binding.toolbar
        toolbar.title = getString((R.string.app_name_simple))
        //установка тулбара, без него не будет меню. некуда крепить их будет
        setSupportActionBar(toolbar)

    }
}