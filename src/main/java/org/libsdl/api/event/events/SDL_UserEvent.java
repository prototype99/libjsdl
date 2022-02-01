package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "code",
        "data1",
        "data2"
})
//A user-defined event type (event.user.*)
public final class SDL_UserEvent extends SDL_CommonWindowEvent {
    //User defined event code
    public int code;
    public Pointer data1;
    public Pointer data2;
}
