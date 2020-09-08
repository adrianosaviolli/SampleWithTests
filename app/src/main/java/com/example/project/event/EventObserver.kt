package com.example.project.event

import androidx.lifecycle.Observer

class EventObserver<T>(onEventChanged: OnEventChanged<T>) : Observer<Event<T>> {

    private var onEventChanged: OnEventChanged<T> = onEventChanged

    override fun onChanged(event: Event<T>?) {
        if (event?.consume() != null) {
            onEventChanged.onChanged(event.peek())
        }
    }
}