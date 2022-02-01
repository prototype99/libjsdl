package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "iscapture",
        "padding1",
        "padding2",
        "padding3"
})
//Audio device event structure (event.adevice.*)
public final class SDL_AudioDeviceEvent extends SDL_JoyDeviceEvent {
    //zero if an output device, non-zero if a capture device.
    public byte iscapture;
    public byte padding1;
    public byte padding2;
    public byte padding3;
}
