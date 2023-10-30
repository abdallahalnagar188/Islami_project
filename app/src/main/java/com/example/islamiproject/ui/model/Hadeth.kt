package com.example.islamiproject.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hadeth(val title:String,
                  val content:String) : Parcelable
