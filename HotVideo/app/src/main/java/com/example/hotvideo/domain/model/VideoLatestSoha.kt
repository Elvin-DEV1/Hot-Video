package com.example.hotvideo.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VideoLatestSoha(
    @SerializedName("Author")
    @Expose
    val author: String,
    @SerializedName("Avatar")
    @Expose
    val avatar: String,
    @SerializedName("Capacity")
    @Expose
    val capacity: Int,
    @SerializedName("CommentCount")
    @Expose
    val commentCount: Int,
    @SerializedName("CommentUrl")
    @Expose
    val commentUrl: String,
    @SerializedName("Description")
    @Expose
    val description: String,
    @SerializedName("DistributionDate")
    @Expose
    val distributionDate: String,
    @SerializedName("Duration")
    @Expose
    val duration: String,
    @SerializedName("FileName")
    @Expose
    val fileName: String,
    @SerializedName("HtmlCode")
    @Expose
    val htmlCode: String,
    @SerializedName("Id")
    @Expose
    val id: Int,
    @SerializedName("KeyVideo")
    @Expose
    val keyVideo: String,
    @SerializedName("Name")
    @Expose
    val name: String,
    @SerializedName("Pname")
    @Expose
    val pname: String,
    @SerializedName("ROW")
    @Expose
    val row: Int,
    @SerializedName("ShareCount")
    @Expose
    val shareCount: Int,
    @SerializedName("Size")
    @Expose
    val size: SizeLatestSoha,
    @SerializedName("SocialCount")
    @Expose
    val socialCount: Int,
    @SerializedName("Source")
    @Expose
    val source: String,
    @SerializedName("SourceLink")
    @Expose
    val sourceLink: String,
    @SerializedName("Url")
    @Expose
    val url: String,
    @SerializedName("UrlShare")
    @Expose
    val urlShare: String,
    @SerializedName("VideoRelation")
    @Expose
    val videoRelation: String,
    @SerializedName("Views")
    @Expose
    val views: Int,
    @SerializedName("ZoneId")
    @Expose
    val zoneId: Int,
    @SerializedName("ZoneName")
    @Expose
    val zoneName: String,
    @SerializedName("ZoneUrl")
    @Expose
    val zoneUrl: String
) : Serializable