package org.libsdl.api.rwops;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.jna.SizeT;

@FunctionalInterface
public interface SDL_RWReadFunction extends Callback {

    SizeT read(
            SDL_RWops context,
            Pointer ptr,
            SizeT itemSize,
            SizeT maxnum);
}
