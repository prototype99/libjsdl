package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder("msg")
/*
   A video driver dependent system event (event.syswm.*)
   This event is disabled by default, you can enable it with SDL_EventState()

   @apiNote If you want to use this event, you should include SDL_syswm.h.
 */
public final class SDL_SysWMEvent extends SDL_CommonEvent {
    //User defined event code
    public Pointer msg;
}
