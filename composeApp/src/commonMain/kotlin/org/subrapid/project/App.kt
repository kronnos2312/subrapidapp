package org.subrapid.project

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.subrapid.project.ui.screens.detail.DetailScreem
import org.subrapid.project.ui.screens.home.HomeScreem
import org.subrapid.project.ui.screens.nav.Navigation

@Composable
@Preview
fun App() {
    setSingletonImageLoaderFactory {
            context ->  ImageLoader.Builder(context)
        .crossfade(true)
        .logger(DebugLogger())
        .build()
    }
    ///DetailScreem()
    Navigation()
}