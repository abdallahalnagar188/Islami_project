package com.example.islamiproject.ui.home.radio

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.islamiproject.R
import com.example.islamiproject.databinding.FragmentRadioBinding
import com.example.islamiproject.doman.entity.Radio
import com.example.islamiproject.ui.home.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RadioFragment : Fragment() {

    private val viewModel: AppViewModel by viewModels()
    private lateinit var binding: FragmentRadioBinding

    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying: Boolean = false
    private var currentIndex: Int = 0
    private var radioList: List<Radio>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchRadio()

        binding.nextButton.setOnClickListener { onNextClicked() }
        binding.previousButton.setOnClickListener { onBackClicked() }
    }

    private fun fetchRadio() {
        viewModel.getRadio()
        lifecycleScope.launch {
            viewModel.radio.collect { state ->
                radioList = state?.radios?.filterNotNull()  // Filter out null values if needed
                if (radioList.isNullOrEmpty()) {
                    Toast.makeText(context, "No radio stations available", Toast.LENGTH_SHORT).show()
                } else {
                    updateRadioStation()
                }

                binding.playButton.setOnClickListener {
                    if (isPlaying) {
                        stopRadio()
                    } else {
                        playRadio()
                    }
                }
            }
        }
    }

    private fun updateRadioStation() {
        if (radioList.isNullOrEmpty() || currentIndex !in radioList!!.indices) return

        val radio = radioList!![currentIndex]
        binding.tvRadioName.text = radio.name

        if (isPlaying) {
            mediaPlayer?.apply {
                stop()
                release()
            }
            playRadio()
        }
    }

    private fun playRadio() {
        if (radioList.isNullOrEmpty() || currentIndex !in radioList!!.indices) return

        try {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(radioList!![currentIndex].url ?: return)
                prepareAsync()
                setOnPreparedListener {
                    it.start()
                    this@RadioFragment.isPlaying = true
                    binding.playButton.setImageResource(R.drawable.pause_btn)
                }
                setOnCompletionListener {
                    stopRadio()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error playing radio", Toast.LENGTH_SHORT).show()
        }
    }

    private fun stopRadio() {
        mediaPlayer?.let { player ->
            if (player.isPlaying) {
                player.stop()
                player.release()
                mediaPlayer = null
                isPlaying = false
                binding.playButton.setImageResource(R.drawable.iconplay)
            }
        }
    }

    private fun onNextClicked() {
        if (radioList.isNullOrEmpty()) return

        currentIndex = (currentIndex + 1) % radioList!!.size
        updateRadioStation()
    }

    private fun onBackClicked() {
        if (radioList.isNullOrEmpty()) return

        currentIndex = (currentIndex - 1 + radioList!!.size) % radioList!!.size
        updateRadioStation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
