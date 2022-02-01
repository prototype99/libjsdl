package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder("which")
//Fields shared by every event
public class SDL_CommonWindowWhichEvent extends SDL_CommonWindowEvent {
    /** The associated instance ID */
    public int which;
}
