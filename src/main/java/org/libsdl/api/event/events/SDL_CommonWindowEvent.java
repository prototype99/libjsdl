package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder("windowID")
//Fields shared by every event
public class SDL_CommonWindowEvent extends SDL_CommonEvent {
    /** The associated window */
    public int windowID;
}
