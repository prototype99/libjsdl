package org.libsdl.api.filesystem;

import com.sun.jna.Pointer;
import org.libsdl.api.stdinc.StringJnaUtils;
import org.libsdl.jna.NativeLoader;

public final class SdlFilesystem {

    public static String SDL_GetBasePath() {
        return StringJnaUtils.extractStringAndReleaseNativeMemory(NativeFunctions.SDL_GetBasePath());
    }

    public static String SDL_GetPrefPath(String org, String app) {
        return StringJnaUtils.extractStringAndReleaseNativeMemory(NativeFunctions.SDL_GetPrefPath(org, app));
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        public static native Pointer SDL_GetBasePath();

        public static native Pointer SDL_GetPrefPath(
                String org,
                String app);
    }
}
