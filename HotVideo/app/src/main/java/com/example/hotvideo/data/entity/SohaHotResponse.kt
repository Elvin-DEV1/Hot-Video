package com.example.hotvideo.data.entity

import com.example.hotvideo.domain.model.VideoHotSoha
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SohaHotResponse(
    @SerializedName("LastUpdated")
    @Expose
    val lastUpdated: LastUpdated,
    @SerializedName("Videos")
    @Expose
    val videos: List<VideoHotSoha>
) : Serializable {
    data class LastUpdated(
        @SerializedName("Data")
        @Expose
        val data: String
    )
}