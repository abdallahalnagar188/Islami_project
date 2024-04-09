package com.example.islamiproject.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamiproject.ui.home.hadeth.HadethFragment
import com.example.islamiproject.ui.home.quran.QuranFragment
import com.example.islamiproject.ui.home.radio.RadioFragment
import com.example.islamiproject.ui.home.sebha.SebhaFragment
import com.example.islamiproject.R
import com.example.islamiproject.databinding.ActivityHomeScreenBinding
import com.example.islamiproject.ui.home.settings.SettingsFragment

class HomeScreen : AppCompatActivity() {
    private lateinit var viewBinding : ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        showFragment(QuranFragment())


        viewBinding.homeNavigationView.setOnItemSelectedListener {item->
            if (item.itemId == R.id.icon_quran){
                showFragment(QuranFragment())
            }
            else if (item.itemId == R.id.icon_hadeth){
                showFragment(HadethFragment())
            }
            else if (item.itemId == R.id.icon_radio){
                showFragment(RadioFragment())
            }
            else if (item.itemId == R.id.icon_sebha){
                showFragment(SebhaFragment())
            }
            else if (item.itemId == R.id.icon_setting){
                showFragment(SettingsFragment())
            }

             return@setOnItemSelectedListener true
        }


    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,fragment).commit()
    }

}