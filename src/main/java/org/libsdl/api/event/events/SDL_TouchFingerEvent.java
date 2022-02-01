package org.libsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "fingerId",
        "x",
        "y",
        "dx",
        "dy",
        "pressure",
        "windowID"
})
//Touch finger event structure (event.tfinger.*)
public final class SDL_TouchFingerEvent extends SDL_CommonTouchIdEvent {
    public NativeLong fingerId;
    //Normalized in the range 0...1
    public float x;
    public float y;
    //Normalized in the range -1...1
    public float dx;
    public float dy;
    //Normalized in the range 0...1
    public float pressure;
    /** The window underneath the finger, if any */
    public int windowID;
}
