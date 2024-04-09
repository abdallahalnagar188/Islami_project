package com.example.islamiproject.ui.home.settings

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.islamiproject.R
import com.example.islamiproject.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private lateinit var viewBinding :FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentSettingsBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            viewBinding.switchMode.text = "Light Mode"
        }else {
            viewBinding.switchMode.text = "Dark Mode"
        }
        viewBinding.switchMode.setOnClickListener {
            if (viewBinding.switchMode.text.toString() == "Dark Mode"){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else if (viewBinding.switchMode.text.toString() == "Night Mode"){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

}