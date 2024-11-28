package com.example.hotvideo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.hotvideo.data.api.VideoApi
import com.example.hotvideo.data.remote.LatestVideoPagingSource
import com.example.hotvideo.domain.model.VideoLatestSoha
import com.example.hotvideo.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow

class VideoRepositoryImpl(
    private val videoApi: VideoApi
) : VideoRepository {
    override fun getVideoLatest(sources: List<String>): Flow<PagingData<VideoLatestSoha>> {
        return  Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                LatestVideoPagingSource(
                    videoApi = videoApi,
                    source = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}