package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "ball",
        "padding1",
        "padding2",
        "padding3",
        "xrel",
        "yrel"
})
//Joystick trackball motion event structure (event.jball.*)
public final class SDL_JoyBallEvent extends SDL_JoyDeviceEvent {
    //The joystick trackball index
    public byte ball;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    //The relative motion in the X direction
    public short xrel;
    //The relative motion in the Y direction
    public short yrel;
}
