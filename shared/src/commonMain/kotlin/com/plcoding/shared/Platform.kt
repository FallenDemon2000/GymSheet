package com.plcoding.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform