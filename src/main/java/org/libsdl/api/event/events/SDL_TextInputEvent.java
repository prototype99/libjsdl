package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder("text")
//Keyboard text input event structure (event.text.*)
public class SDL_TextInputEvent extends SDL_CommonWindowEvent {
    private static final int BUF_SIZE = 32;
    //The editing text
    public byte[] text = new byte[BUF_SIZE];
}
