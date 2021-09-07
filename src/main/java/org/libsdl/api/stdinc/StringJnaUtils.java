package org.libsdl.api.stdinc;

import com.sun.jna.Pointer;

import static org.libsdl.api.stdinc.SdlStdinc.SDL_free;

public class StringJnaUtils {

    public static String extractStringAndReleaseNativeMemory(Pointer pointer) {
        String result = pointer.getString(0L);
        SDL_free(pointer);
        return result;
    }
}
