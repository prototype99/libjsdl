package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.SizeT;

@Structure.FieldOrder({
        "data",
        "size",
        "left"
})
public final class SDL_RWopsIOBuffer extends Structure {

    public Pointer data;
    public SizeT size;
    public SizeT left;
}
