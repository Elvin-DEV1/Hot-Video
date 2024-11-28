package com.example.hotvideo.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SizeHotSoha(
    @SerializedName("height")
    @Expose
    val height: Int,
    @SerializedName("width")
    @Expose
    val width: Int
) : Serializable