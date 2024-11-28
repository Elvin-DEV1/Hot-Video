package com.example.hotvideo.domain.repository


import androidx.paging.PagingData
import com.example.hotvideo.domain.model.VideoLatestSoha
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    fun getVideoLatest(sources: List<String>) : Flow<PagingData<VideoLatestSoha>>

}