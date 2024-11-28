package com.example.hotvideo.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hotvideo.domain.usecases.video.VideoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val videoUseCases: VideoUseCases
) : ViewModel(

) {
    val video = videoUseCases.getVideo(
        sources = listOf("10", "20")
    ).cachedIn(viewModelScope)
}