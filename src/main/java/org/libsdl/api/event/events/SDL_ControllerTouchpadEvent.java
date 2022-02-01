package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "touchpad",
        "finger",
        "x",
        "y",
        "pressure"
})
//Game controller touchpad event structure (event.ctouchpad.*)
public final class SDL_ControllerTouchpadEvent extends SDL_JoyDeviceEvent {
    /** The index of the touchpad */
    public int touchpad;
    /** The index of the finger on the touchpad */
    public int finger;
    /** Normalized in the range 0...1 with 0 being on the left */
    public float x;
    /** Normalized in the range 0...1 with 0 being at the top */
    public float y;
    /** Normalized in the range 0...1 */
    public float pressure;
}