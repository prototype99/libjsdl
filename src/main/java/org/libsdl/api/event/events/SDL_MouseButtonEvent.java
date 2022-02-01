package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "button",
        "state",
        "clicks",
        "padding1",
        "x",
        "y"
})
//Mouse button event structure (event.button.*)
public final class SDL_MouseButtonEvent extends SDL_CommonWindowWhichEvent {
    //The mouse button index
    public byte button;
    //::SDL_PRESSED or ::SDL_RELEASED
    public byte state;
    //1 for single-click, 2 for double-click, etc.
    public byte clicks;
    public byte padding1;
    //X coordinate, relative to window
    public int x;
    //Y coordinate, relative to window
    public int y;
}
