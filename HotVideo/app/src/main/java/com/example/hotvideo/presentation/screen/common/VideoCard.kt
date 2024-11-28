package com.example.hotvideo.presentation.screen.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.hotvideo.R
import com.example.hotvideo.domain.model.SizeLatestSoha
import com.example.hotvideo.domain.model.VideoLatestSoha
import com.example.hotvideo.presentation.screen.Dimens.IconSize
import com.example.hotvideo.ui.theme.HotVideoTheme

@Composable
fun VideoCard(
    modifier: Modifier = Modifier,
    video: VideoLatestSoha,
    onClick: (() -> Unit)? = null,
    onShareClick: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                if (onClick != null) {
                    onClick()
                }
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(video.avatar)
                    .crossfade(true)
                    .build(),
                contentDescription = "Video thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = video.duration,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.volume_off),
                contentDescription = "Volume off",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(Color.Black.copy(alpha = 0.4f), RoundedCornerShape(IconSize))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = video.name,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = video.zoneName,
                    style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = { onShareClick(video.urlShare) }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Theo ${video.source}",
                style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = video.distributionDate,
                style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray)
            )
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun VideoCardPreview() {
    HotVideoTheme {
        val context = LocalContext.current
        VideoCard(
            video = VideoLatestSoha(
                id = 13019,
                name = "Thị trấn tạc trong vách đá",
                zoneId = 1984,
                zoneName = "Chuyện lạ",
                zoneUrl = "chuyen-la",
                description = "Cliff Palace nằm trong vườn quốc gia Mesa Verde ở Colorado (Mỹ) được đánh giá là công trình nhà ở trên vách đá lớn nhất ở Bắc Mỹ.",
                htmlCode = "https://player.sohatv.vn/embed/100646?vid=sohanews.sohacdn.com/160588918557773824/2024/11/28/thi-tran-tac-trong-vach-da-1732776885098308785176.mp4&ads=true&autoplay=false&_info=58e742911cb7bc3067d835c98d05b090&poster=https://sohanews.sohacdn.com/.v-thumb/160588918557773824/2024/11/28/thi-tran-tac-trong-vach-da-1732776885098308785176.mp4.jpg&location=",
                avatar = "https://sohanews.sohacdn.com/160588918557773824/2024/11/28/chrome-capture-2024-11-28-2-1732776970712217333166-0-0-503-894-crop-17327769753772087879391.gif",
                keyVideo = "58e742911cb7bc3067d835c98d05b090",
                pname = "",
                views = 0,
                distributionDate = "2024-11-28T13:56:00.000Z",
                url = "/video/thi-tran-tac-trong-vach-da-13019.htm",
                urlShare = "http://soha.vn/video/thi-tran-tac-trong-vach-da-13019.htm",
                source = "VTC NEWS",
                sourceLink = "https://vtcnews.vn/thi-tran-tac-trong-vach-da-ar910054.html",
                author = "Chí Bảo - Vân Khánh(Nguồn: National Geographic)/VTC NEWS",
                videoRelation = "",
                fileName = "https://sohanews.sohacdn.com/.hls/160588918557773824/2024/11/28/thi-tran-tac-trong-vach-da-1732776885098308785176.mp4.mobile.m3u8",
                duration = "00:01:04.75",
                size = SizeLatestSoha(
                    1280,
                    720
                ),
                capacity = 82280510,
                row = 1,
                commentUrl = "http://m.comment.vietid.net/comments?app_key=d9397051b44ba718cc57c54a881cd19e&content_url=http://soha.vn/video/v13019.chn&news_title=VGjhu4sgdHLhuqVuIHThuqFjIHRyb25nIHbDoWNoIMSRw6E=&num_count=5&debugcache=1&min=0&scroll=0&http_referer=http://https://m.soha.vn/app/video/thi-tran-tac-trong-vach-da-13019.htm&background_iframe=1&custom_flag=1&is_app=1&news_url_short=0&verify=0&verify_flag=0",
                commentCount = 0,
                shareCount = 0,
                socialCount = 17
            ),
            onShareClick = { urlShare ->
                val intent = android.content.Intent().apply {
                    action = android.content.Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(android.content.Intent.EXTRA_TEXT, urlShare)
                }
                context.startActivity(android.content.Intent.createChooser(intent, "Chia sẻ video qua"))
            }
        )
    }
}