package com.example.project.event

interface OnEventChanged<T> {
    fun onChanged(data: T)
}