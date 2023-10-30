package com.example.islamiproject.ui.sura_details


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamiproject.Constants
import com.example.islamiproject.databinding.ActivitySuraDetailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class SuraDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivitySuraDetailsBinding
    var suraContent: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val suraName = intent.getStringExtra(Constants.SURA_NAME)
        val fileName = intent.getStringExtra(Constants.FILE_NAME)



        viewBinding.btnBack.setOnClickListener {
            finish()
        }
        viewBinding.suraDetailsTv.text = suraName
        readSuraContent(fileName ?: "")
        var content = ""
        for (i in 0..suraContent.size - 1) {
            content += suraContent.get(i) + "(${i + 1})"
        }
        viewBinding.suraDetailsTv.text = content
    }

    private fun readSuraContent(fileName: String) {
        val reader: BufferedReader

        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            suraContent = reader.readLines().toMutableList()

        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }

    }
}


