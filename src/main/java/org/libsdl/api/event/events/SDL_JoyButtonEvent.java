package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "button",
        "state",
        "padding1",
        "padding2"
})
//Joystick button event structure (event.jbutton.*)
public class SDL_JoyButtonEvent extends SDL_JoyDeviceEvent {
    //The button
    public byte button;
    //::SDL_PRESSED or ::SDL_RELEASED
    public byte state;
    public byte padding1;
    public byte padding2;
}
