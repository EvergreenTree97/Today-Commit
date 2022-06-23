package com.evergreen.todaycommit

internal object Utils{
    fun readResourceString(fileName: String) =
        this::class.java.classLoader?.getResource(fileName)?.readText().orEmpty()
}