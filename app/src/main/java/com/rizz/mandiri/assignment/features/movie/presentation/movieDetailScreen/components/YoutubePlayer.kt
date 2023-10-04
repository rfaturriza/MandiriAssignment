package com.rizz.mandiri.assignment.features.movie.presentation.movieDetailScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun YoutubeScreen(
    videoId: String,
    modifier: Modifier = Modifier
) {
    val ctx = LocalContext.current
    val lifecycle = (ctx as LifecycleOwner).lifecycle
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AndroidView(factory = {
            val view = YouTubePlayerView(it).apply {
                lifecycle.addObserver(this)
            }
            view.addYouTubePlayerListener(
                object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.loadVideo(videoId, 0f)
                    }
                }
            )
            view
        })
    }
}