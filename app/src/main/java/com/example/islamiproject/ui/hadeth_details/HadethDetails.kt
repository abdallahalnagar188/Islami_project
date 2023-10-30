package com.example.islamiproject.ui.hadeth_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamiproject.Constants
import com.example.islamiproject.databinding.ActivityHadethDetailsBinding
import com.example.islamiproject.ui.model.Hadeth

class HadethDetails : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initParams()
        bindHadeth()
        binding.btnBack.setOnClickListener {
            finish()
        }
    }


    private fun bindHadeth() {
        binding.hadethTitleTv.text = hadeth?.title
        binding.hadethDetailsTv.text = hadeth?.content
    }

    var hadeth: Hadeth? =null
    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH,Hadeth::class.java)
        }else{
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH)
        }
    }
}