package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x",
        "y",
        "direction"
})
//Mouse wheel event structure (event.wheel.*)
public final class SDL_MouseWheelEvent extends SDL_CommonWindowWhichEvent {
    //The amount scrolled horizontally, positive to the right and negative to the left
    public int x;
    //The amount scrolled vertically, positive away from the user and negative toward the user
    public int y;
    //Set to one of the SDL_MOUSEWHEEL_* defines. When FLIPPED the values in X and Y will be opposite. Multiply by -1 to change them back
    public int direction;
}
