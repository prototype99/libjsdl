package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "dTheta",
        "dDist",
        "x",
        "y",
        "numFingers",
        "padding"
})
//Multiple Finger Gesture Event (event.mgesture.*)
public final class SDL_MultiGestureEvent extends SDL_CommonTouchIdEvent {
    public float dTheta;
    public float dDist;
    public float x;
    public float y;
    public short numFingers;
    public short padding;
}
