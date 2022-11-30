package com.example.androidtrnslator.domain.dtomodel

import com.google.gson.annotations.SerializedName
import geekbrains.ru.translator.model.data.Meanings

class DataModel(
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
)
