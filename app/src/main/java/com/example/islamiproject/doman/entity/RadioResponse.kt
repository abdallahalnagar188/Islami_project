package com.example.islamiproject.doman.entity

data class RadioResponse(
    val radios: List<Radio?>?
)
data class Radio(
    val id: Int?,
    val name: String?,
    val recent_date: String?,
    val url: String?
)