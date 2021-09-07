package org.libsdl.api.filesystem;

import org.libsdl.api.stdinc.StringRef;
import org.libsdl.jna.NativeLoader;

public final class SdlFilesystem2 {

    static {
        NativeLoader.registerNativeMethods(SdlFilesystem2.class);
    }

    private SdlFilesystem2() {
    }

    public static native StringRef SDL_GetBasePath();

    public static native StringRef SDL_GetPrefPath(
            String org,
            String app);
}
