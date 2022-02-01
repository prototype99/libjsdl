package org.libsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "gestureId",
        "numFingers",
        "error",
        "x",
        "y"
})
//Dollar Gesture Event (event.dgesture.*)
public final class SDL_DollarGestureEvent extends SDL_CommonTouchIdEvent {
    public NativeLong gestureId;
    public int numFingers;
    public float error;
    //Normalized center of gesture
    public float x;
    public float y;
}
