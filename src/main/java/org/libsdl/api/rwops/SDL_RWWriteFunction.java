package org.libsdl.api.rwops;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.jna.SizeT;

@FunctionalInterface
public interface SDL_RWWriteFunction extends Callback {

    SizeT write(
            SDL_RWops context,
            Pointer ptr,
            SizeT size,
            SizeT num);
}
