package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "file",
        "windowID"
})
/*
  An event used to request a file open by the system (event.drop.*)
  This event is enabled by default, you can disable it with SDL_EventState().

  @apiNote If this event is enabled, you must free the filename in the event.
 */
public final class SDL_DropEvent extends SDL_CommonEvent {
    //The file name, which should be freed with SDL_free(), is NULL on begin/complete
    public Pointer file;
    //The window that was dropped on, if any
    public int windowID;
}
