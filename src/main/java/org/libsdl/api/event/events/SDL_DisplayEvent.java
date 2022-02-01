package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "event",
        "padding1",
        "padding2",
        "padding3",
        "data1"
})
//Display state change event data (event.display.*)
public final class SDL_DisplayEvent extends SDL_CommonEvent {
    /** The associated display index */
    public int display;
    public byte event;
    public int padding1;
    public int padding2;
    public int padding3;
    /** event dependent data */
    public int data1;
}