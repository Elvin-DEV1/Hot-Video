package com.example.hotvideo.data.api

import com.example.hotvideo.data.entity.SohaLatestResponse
import com.example.hotvideo.util.Constant.API_KEY
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface VideoApi {
    @POST("/app/video/lastest")
    @FormUrlEncoded
    suspend fun getVideoLatest(
        @Field("secret_key") secretKey: String = API_KEY,
        @Field("page_index") pageIndex: String,
        @Field("page-size") pageSize: String
    ) : SohaLatestResponse

    @POST("/app/video/hot")
    @FormUrlEncoded
    suspend fun getVideoHot(
        @Field("secret_key") secretKey: String = API_KEY
    )
}