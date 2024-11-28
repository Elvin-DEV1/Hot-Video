package com.example.hotvideo.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.hotvideo.data.api.VideoApi
import com.example.hotvideo.domain.model.VideoLatestSoha

class LatestVideoPagingSource(
    private val videoApi: VideoApi,
    private val source: String
) : PagingSource<Int, VideoLatestSoha>() {

    private var totalVideoCount = 0

    override fun getRefreshKey(state: PagingState<Int, VideoLatestSoha>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoLatestSoha> {
        val page = params.key ?: 1
        return try {
            val latestVideoResponse =
                videoApi.getVideoLatest(pageSize = source, pageIndex = page.toString())
            totalVideoCount += latestVideoResponse.videos.size
            val video = latestVideoResponse.videos.distinctBy { it.name }
            LoadResult.Page(
                data = video,
                nextKey = if (totalVideoCount == 10) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

}