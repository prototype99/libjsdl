package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "hat",
        "value",
        "padding1",
        "padding2"
})
//Joystick hat position change event structure (event.jhat.*)
public final class SDL_JoyHatEvent extends SDL_JoyDeviceEvent {
    //The joystick hat index
    public byte hat;
    /**
     * The hat position value.
     * @apiNote Note that zero means the POV is centered.
     */
    public byte value;
    public byte padding1;
    public byte padding2;
}
