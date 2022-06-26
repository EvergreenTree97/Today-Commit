package com.evergreen.todaycommit.util

import java.io.File

internal object Utils {
    fun readResourceString(fileName: String): String {
        val file = File(javaClass.classLoader?.getResource(fileName)?.file)
        return file.bufferedReader().use {
            val str = it.readText()
            it.close()
            str
        }
    }
}