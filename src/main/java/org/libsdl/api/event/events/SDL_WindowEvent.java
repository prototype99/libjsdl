package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "event",
        "padding1",
        "padding2",
        "padding3",
        "data1",
        "data2"
})
//Window state change event data (event.window.*)
public final class SDL_WindowEvent extends SDL_CommonWindowEvent {
    public byte event;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    /** event dependent data */
    public int data1;
    public int data2;
}
