package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "axis",
        "padding1",
        "padding2",
        "padding3",
        "value",
        "padding4"
})
//Joystick axis motion event structure (event.jaxis.*)
public class SDL_JoyAxisEvent extends SDL_JoyDeviceEvent {
    //The axis
    public int axis;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    //The axis value (range: -32768 to 32767)
    public short value;
    public short padding4;
}
