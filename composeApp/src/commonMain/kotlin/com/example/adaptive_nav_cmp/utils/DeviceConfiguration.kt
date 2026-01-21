package com.example.adaptive_nav_cmp.utils;

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

enum class DeviceConfiguration {
    MOBILE_PORTRAIT,
    MOBILE_LANDSCAPE,
    TABLET_PORTRAIT,
    TABLET_LANDSCAPE,
    DESKTOP;

    companion object {

        fun fromWindowSizeClass(
            windowSizeClass: WindowSizeClass
        ): DeviceConfiguration {

            val width = windowSizeClass.widthSizeClass
            val height = windowSizeClass.heightSizeClass

            return when {
                // 📱 Phone portrait
                width == WindowWidthSizeClass.Compact &&
                        height != WindowHeightSizeClass.Compact ->
                    MOBILE_PORTRAIT

                // 📱 Phone landscape
                width == WindowWidthSizeClass.Compact &&
                        height == WindowHeightSizeClass.Compact ->
                    MOBILE_LANDSCAPE

                // 📲 Tablet portrait
                width == WindowWidthSizeClass.Medium &&
                        height == WindowHeightSizeClass.Expanded ->
                    TABLET_PORTRAIT

                // 📲 Tablet landscape
                width == WindowWidthSizeClass.Medium &&
                        height != WindowHeightSizeClass.Expanded ->
                    TABLET_LANDSCAPE

                // 🖥 Large screens
                width == WindowWidthSizeClass.Expanded ->
                    DESKTOP

                else -> DESKTOP
            }
        }
    }
}
