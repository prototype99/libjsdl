package org.libsdl.api.hints;

import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class SdlHints {

    static {
        NativeLoader.registerNativeMethods(SdlHints.class);
    }

    private SdlHints() {
    }

    /**
     * <p>Set a hint with a specific priority.</p>
     *
     * <p>The priority controls the behavior when setting a hint that already has a
     * value. Hints will replace existing hints of their priority and lower.
     * Environment variables are considered to have override priority.</p>
     *
     * @param name the hint to set
     * @param value the value of the hint variable
     * @param priority the SDL_HintPriority level for the hint
     * @return SDL_TRUE if the hint was set, SDL_FALSE otherwise.
     *
     * @see #SDL_GetHint
     * @see #SDL_SetHint
     */
    public static native boolean SDL_SetHintWithPriority(
            String name,
            String value,
            @MagicConstant(valuesFromClass = SDL_HintPriority.class) int priority);

    public static native boolean SDL_SetHint(
            String name,
            String value);

    public static native String SDL_GetHint(
            String name);

    /**
     * Get the boolean value of a hint variable.
     *
     * @param name the name of the hint to get the boolean value from
     * @param default_value the value to return if the hint does not exist
     * @return the boolean value of a hint or the provided default value if the
     *         hint does not exist.
     *
     * @since This function is available since SDL 2.0.5.
     *
     * @see #SDL_GetHint
     * @see #SDL_SetHint
     */
    public static native boolean SDL_GetHintBoolean(
            String name,
            boolean defaultValue);

    public static native void SDL_AddHintCallback(
            String name,
            SDL_HintCallback callback,
            Pointer userdata);

    public static native void SDL_DelHintCallback(
            String name,
            SDL_HintCallback callback,
            Pointer userdata);

    public static native void SDL_ClearHints();
}
