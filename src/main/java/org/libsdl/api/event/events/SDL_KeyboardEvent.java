package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.libsdl.api.keyboard.SDL_Keysym;

@Structure.FieldOrder({
        "state",
        "repeat",
        "padding2",
        "padding3",
        "keysym"
})
//Keyboard button event structure (event.key.*)
public final class SDL_KeyboardEvent extends SDL_CommonWindowEvent {
    public byte state;
    //Non-zero if this is a key repeat
    public byte repeat;
    public byte padding2;
    public byte padding3;
    //The key that was pressed or released
    public SDL_Keysym keysym;
}
