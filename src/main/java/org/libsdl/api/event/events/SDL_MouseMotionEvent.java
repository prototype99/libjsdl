package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "state",
        "x",
        "y",
        "xrel",
        "yrel"
})
//Mouse motion event structure (event.motion.*)
public final class SDL_MouseMotionEvent extends SDL_CommonWindowWhichEvent {
    //The current button state
    public int state;
    //X coordinate, relative to window
    public int x;
    //Y coordinate, relative to window
    public int y;
    //The relative motion in the X direction
    public int xrel;
    //The relative motion in the Y direction
    public int yrel;
}
