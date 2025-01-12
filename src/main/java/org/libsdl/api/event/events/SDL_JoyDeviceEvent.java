package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder("which")
//Joystick device event structure (event.jdevice.*)
public class SDL_JoyDeviceEvent extends SDL_CommonEvent {
    /** The associated instance ID */
    public int which;
}
