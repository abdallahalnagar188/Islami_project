package com.example.islamiproject.ui.home.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamiproject.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding
    lateinit var imageSeb7a: ImageView
    lateinit var tvCounter: TextView
    lateinit var tvTasbeh: TextView

    var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageSeb7a = viewBinding.imageSebha
        tvCounter = viewBinding.tvCounterTasbeh
        tvTasbeh = viewBinding.textTasbeh

        tvTasbeh.text= ConstantsSebha.SOBHAN_ALLAH
        tvCounter.text= "$counter"

        tvTasbeh.setOnClickListener{
            onClickImageSeb7a()

        }

    }
    private fun onClickImageSeb7a(){
        imageSeb7a.rotation += 5
        counter++
        tvCounter.text="$counter"
        if (tvTasbeh.text == ConstantsSebha.LAELAHELA_ALLAH){
            counter = 0
            tvCounter.text = "$counter"
        }
        when (counter) {
            33 -> {
                if (tvTasbeh.text == ConstantsSebha.SOBHAN_ALLAH)
                    tvTasbeh.text = ConstantsSebha.ALHAMDLLAH
                tvCounter.text = "$counter"

            }
            66 -> {
                if(tvTasbeh.text == ConstantsSebha.ALHAMDLLAH)
                    tvTasbeh.text = ConstantsSebha.ALLAH_AKBER
                tvCounter.text = "$counter"
            }
            99 -> {
                if(tvTasbeh.text == ConstantsSebha.ALLAH_AKBER)
                    tvTasbeh.text = ConstantsSebha.LAELAHELA_ALLAH
                counter =0
                tvCounter.text = "$counter"
            }
        }

    }
}