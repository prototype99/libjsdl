package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "start",
        "length"
})
//Keyboard text editing event structure (event.edit.*)
public final class SDL_TextEditingEvent extends SDL_TextInputEvent {
    //The start cursor of selected editing text
    public int start;
    //The length of selected editing text
    public int length;
}
