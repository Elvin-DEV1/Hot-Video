package com.example.hotvideo.domain.usecases.video

import androidx.paging.PagingData
import com.example.hotvideo.domain.model.VideoLatestSoha
import com.example.hotvideo.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow

class GetVideo(
    private val videoRepository: VideoRepository
) {
    operator fun invoke(sources: List<String>) : Flow<PagingData<VideoLatestSoha>> {
        return videoRepository.getVideoLatest(sources = sources)
    }
}