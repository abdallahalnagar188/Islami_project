package com.example.islamiproject.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiproject.R
import com.example.islamiproject.databinding.ActivityHomeScreenBinding
import com.example.islamiproject.ui.home.hadeth.HadethFragment
import com.example.islamiproject.ui.home.quran.QuranFragment
import com.example.islamiproject.ui.home.radio.RadioFragment
import com.example.islamiproject.ui.home.sebha.SebhaFragment
import com.example.islamiproject.ui.home.settings.SettingsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreen : AppCompatActivity() {

    private lateinit var viewBinding : ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        showFragment(QuranFragment())


        viewBinding.homeNavigationView.setOnItemSelectedListener {item->
            when (item.itemId) {
                R.id.icon_quran -> {
                    showFragment(QuranFragment())
                }
                R.id.icon_hadeth -> {
                    showFragment(HadethFragment())
                }
                R.id.icon_radio -> {
                    showFragment(RadioFragment())
                }
                R.id.icon_sebha -> {
                    showFragment(SebhaFragment())
                }
                R.id.icon_setting -> {
                    showFragment(SettingsFragment())
                }
            }

             return@setOnItemSelectedListener true
        }


    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,fragment).commit()
    }

}