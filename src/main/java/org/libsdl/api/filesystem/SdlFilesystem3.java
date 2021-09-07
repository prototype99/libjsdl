package org.libsdl.api.filesystem;

import org.libsdl.api.stdinc.SdlReleaseCharRefMemory;
import org.libsdl.jna.NativeLoader;

public final class SdlFilesystem3 {

    static {
        NativeLoader.registerNativeMethods(SdlFilesystem3.class);
    }

    private SdlFilesystem3() {
    }

    @SdlReleaseCharRefMemory
    public static native String SDL_GetBasePath();

    @SdlReleaseCharRefMemory
    public static native String SDL_GetPrefPath(
            String org,
            String app);
}
