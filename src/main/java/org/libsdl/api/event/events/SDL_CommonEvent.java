package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
//Fields shared by every event
public class SDL_CommonEvent extends Structure {
    public int type;
    //In milliseconds, populated using SDL_GetTicks()
    public int timestamp;
}
