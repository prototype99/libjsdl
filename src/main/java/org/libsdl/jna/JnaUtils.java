package org.libsdl.jna;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import static org.libsdl.api.stdinc.SdlStdinc.SDL_Free;

public final class JnaUtils {

    private JnaUtils() {
    }

    public static String extractStringAndReleaseNativeMemory(Pointer pointer) {
        String result = pointer.getString(0L);
        SDL_Free(pointer);
        return result;
    }

    public static Memory writeArrayToNativeMemory(JnaStructure[] objects) {
        if (objects == null || objects.length == 0) {
            throw new IllegalArgumentException("Array of objects must not be empty or null.");
        }
        int size = objects[0].size();
        Memory memory = new Memory((long) objects.length * size);
        int offset = 0;
        for (JnaStructure singleObject : objects) {
            Pointer backup = singleObject.getPointer();
            singleObject.useMemory(memory, offset);
            singleObject.write();
            singleObject.useMemory(backup, 0);
            offset += size;
        }
        return memory;
    }
}
