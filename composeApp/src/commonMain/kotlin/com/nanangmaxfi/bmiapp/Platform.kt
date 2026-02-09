package com.nanangmaxfi.bmiapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform