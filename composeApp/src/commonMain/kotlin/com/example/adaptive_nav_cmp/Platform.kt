package com.example.adaptive_nav_cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform