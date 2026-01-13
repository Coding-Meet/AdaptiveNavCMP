package com.example.adaptive_nav_cmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "AdaptiveNavCMP",
    ) {
        App()
    }
}