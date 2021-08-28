package com.murattuzel.catchsomezs.internal.util

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import dagger.hilt.android.qualifiers.ActivityContext
import timber.log.Timber
import javax.inject.Inject

class ExoPlayerManager @Inject constructor(
    @ActivityContext private val context: Context
) : LifecycleObserver {

    private lateinit var player: SimpleExoPlayer
    private lateinit var mediaUrl: String
    private lateinit var controllerView: PlayerControlView

    fun inject(mediaUrl: String, controllerView: PlayerControlView) {
        this.mediaUrl = mediaUrl
        this.controllerView = controllerView
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Timber.d("onStart")
        initializePlayer()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Timber.d("onPause")
        releasePlayer()
    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(context, DefaultRenderersFactory(context))
            .setMediaSourceFactory(createDefaultMediaSourceFactory())
            .setTrackSelector(DefaultTrackSelector(context))
            .build().apply {
                controllerView.player = this
                playWhenReady = true
                setMediaItem(createMediaItem())
                prepare()
            }
    }

    private fun releasePlayer() {
        player.release()
    }

    private fun createMediaItem(): MediaItem = MediaItem.fromUri(mediaUrl)

    private fun createDefaultMediaSourceFactory(): DefaultMediaSourceFactory {
        val dataSourceFactory = DefaultDataSourceFactory(context, "yawn")
        return DefaultMediaSourceFactory(dataSourceFactory)
    }
}
