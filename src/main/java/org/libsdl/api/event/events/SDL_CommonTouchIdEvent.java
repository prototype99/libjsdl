package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder("touchId")
public class SDL_CommonTouchIdEvent extends SDL_CommonEvent {
    //The touch device id
    public int touchId;
}
