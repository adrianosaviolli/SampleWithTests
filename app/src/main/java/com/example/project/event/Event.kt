package com.example.project.event

class Event<T>(private val content: T) {

    private var consumed = false

    fun consume(): T? {
        return if (consumed) {
            null
        } else {
            consumed = true
            content
        }
    }

    fun peek(): T {
        return content
    }
}