package org.libsdl.api.mouse;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.event.SdlEvents.SDL_DISABLE;
import static org.libsdl.api.event.SdlEvents.SDL_ENABLE;
import static org.libsdl.api.event.SdlEvents.SDL_QUERY;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public final class SdlMouse {

    public static final int SDL_BUTTON_LEFT = 1;
    public static final int SDL_BUTTON_MIDDLE = 2;
    public static final int SDL_BUTTON_RIGHT = 3;
    public static final int SDL_BUTTON_X1 = 4;
    public static final int SDL_BUTTON_X2 = 5;
    public static final int SDL_BUTTON_LMASK = SDL_BUTTON(SDL_BUTTON_LEFT);
    public static final int SDL_BUTTON_MMASK = SDL_BUTTON(SDL_BUTTON_MIDDLE);
    public static final int SDL_BUTTON_RMASK = SDL_BUTTON(SDL_BUTTON_RIGHT);
    public static final int SDL_BUTTON_X1MASK = SDL_BUTTON(SDL_BUTTON_X1);
    public static final int SDL_BUTTON_X2MASK = SDL_BUTTON(SDL_BUTTON_X2);

    private SdlMouse() {
    }

    public static int SDL_BUTTON(
            int x) {
        return 1 << (x - 1);
    }

    public static SDL_Window SDL_GetMouseFocus() {
        return NativeFunctions.SDL_GetMouseFocus();
    }

    @MagicConstant(flagsFromClass = SdlMouse.class)
    public static int SDL_GetMouseState(IntByReference x, IntByReference y) {
        return NativeFunctions.SDL_GetMouseState(x, y);
    }

    @MagicConstant(flagsFromClass = SdlMouse.class)
    public static int SDL_GetGlobalMouseState(IntByReference x, IntByReference y) {
        return NativeFunctions.SDL_GetGlobalMouseState(x, y);
    }

    @MagicConstant(flagsFromClass = SdlMouse.class)
    public static int SDL_GetRelativeMouseState(IntByReference x, IntByReference y) {
        return NativeFunctions.SDL_GetRelativeMouseState(x, y);
    }

    public static void SDL_WarpMouseInWindow(SDL_Window window, int x, int y) {
        NativeFunctions.SDL_WarpMouseInWindow(window, x, y);
    }

    public static int SDL_WarpMouseGlobal(int x, int y) {
        return NativeFunctions.SDL_WarpMouseGlobal(x, y);
    }

    public static int SDL_SetRelativeMouseMode(boolean enabled) {
        return NativeFunctions.SDL_SetRelativeMouseMode(enabled);
    }

    public static int SDL_CaptureMouse(boolean enabled) {
        return NativeFunctions.SDL_CaptureMouse(enabled);
    }

    public static boolean SDL_GetRelativeMouseMode() {
        return NativeFunctions.SDL_GetRelativeMouseMode();
    }

    // TODO: Replace by bitmap
    public static SDL_Cursor SDL_CreateCursor(Pointer data, Pointer mask, int w, int h, int hotX, int hotY) {
        return NativeFunctions.SDL_CreateCursor(data, mask, w, h, hotX, hotY);
    }

    public static SDL_Cursor SDL_CreateColorCursor(SDL_Surface surface, int hotX, int hotY) {
        return NativeFunctions.SDL_CreateColorCursor(surface, hotX, hotY);
    }

    public static SDL_Cursor SDL_CreateSystemCursor(
            @MagicConstant(valuesFromClass = SDL_SystemCursor.class) int id) {
        return NativeFunctions.SDL_CreateSystemCursor(id);
    }

    public static void SDL_SetCursor(SDL_Cursor cursor) {
        NativeFunctions.SDL_SetCursor(cursor);
    }

    public static SDL_Cursor SDL_GetCursor() {
        return NativeFunctions.SDL_GetCursor();
    }

    public static SDL_Cursor SDL_GetDefaultCursor() {
        return NativeFunctions.SDL_GetDefaultCursor();
    }

    public static void SDL_FreeCursor(SDL_Cursor cursor) {
        NativeFunctions.SDL_FreeCursor(cursor);
    }

    @MagicConstant(intValues = {SDL_ENABLE, SDL_DISABLE})
    public static int SDL_ShowCursor(
            @MagicConstant(intValues = { SDL_ENABLE, SDL_DISABLE, SDL_QUERY }) int toggle) {
        return NativeFunctions.SDL_ShowCursor(toggle);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
        }

        public static native SDL_Window SDL_GetMouseFocus();

        /**
         * <p>Retrieve the current state of the mouse.</p>
         *
         * <p>The current button state is returned as a button bitmask, which can be
         * tested using the {@code SDL_BUTTON(X)} macros (where {@code X} is generally 1 for the
         * left, 2 for middle, 3 for the right button), and {@code x} and {@code y} are set to the
         * mouse cursor position relative to the focus window. You can pass NULL for
         * either {@code x} or {@code y}.</p>
         *
         * @param x the x coordinate of the mouse cursor position relative to the
         *          focus window
         * @param y the y coordinate of the mouse cursor position relative to the
         *          focus window
         * @return a 32-bit button bitmask of the current button state.
         *
         * @see #SDL_GetGlobalMouseState
         * @see #SDL_GetRelativeMouseState
         * @see #SDL_PumpEvents
         */
        @MagicConstant(flagsFromClass = SdlMouse.class)
        public static native int SDL_GetMouseState(
                IntByReference x,
                IntByReference y);

        /**
         * <p>Get the current state of the mouse in relation to the desktop.</p>
         *
         * <p>This works similarly to SDL_GetMouseState(), but the coordinates will be
         * reported relative to the top-left of the desktop. This can be useful if you
         * need to track the mouse outside of a specific window and SDL_CaptureMouse()
         * doesn't fit your needs. For example, it could be useful if you need to
         * track the mouse while dragging a window, where coordinates relative to a
         * window might not be in sync at all times.</p>
         *
         * <p>Note: SDL_GetMouseState() returns the mouse position as SDL understands it
         * from the last pump of the event queue. This function, however, queries the
         * OS for the current mouse position, and as such, might be a slightly less
         * efficient function. Unless you know what you're doing and have a good
         * reason to use this function, you probably want SDL_GetMouseState() instead.</p>
         *
         * @param x filled in with the current X coord relative to the desktop; can be
         *          NULL
         * @param y filled in with the current Y coord relative to the desktop; can be
         *          NULL
         * @return the current button state as a bitmask which can be tested using
         *         the SDL_BUTTON(X) macros.
         *
         * @since This function is available since SDL 2.0.4.
         *
         * @see #SDL_CaptureMouse
         */
        @MagicConstant(flagsFromClass = SdlMouse.class)
        public static native int SDL_GetGlobalMouseState(
                IntByReference x,
                IntByReference y);

        @MagicConstant(flagsFromClass = SdlMouse.class)
        public static native int SDL_GetRelativeMouseState(
                IntByReference x,
                IntByReference y);

        public static native void SDL_WarpMouseInWindow(
                SDL_Window window,
                int x,
                int y);

        public static native int SDL_WarpMouseGlobal(
                int x,
                int y);

        public static native int SDL_SetRelativeMouseMode(
                boolean enabled);

        public static native int SDL_CaptureMouse(boolean enabled);

        public static native boolean SDL_GetRelativeMouseMode();

        public static native SDL_Cursor SDL_CreateCursor(
                Pointer data,
                Pointer mask,
                int w,
                int h,
                int hotX,
                int hotY);

        public static native SDL_Cursor SDL_CreateColorCursor(
                SDL_Surface surface,
                int hotX,
                int hotY);

        public static native SDL_Cursor SDL_CreateSystemCursor(
                @MagicConstant(valuesFromClass = SDL_SystemCursor.class) int id);

        public static native void SDL_SetCursor(
                SDL_Cursor cursor);

        public static native SDL_Cursor SDL_GetCursor();

        public static native SDL_Cursor SDL_GetDefaultCursor();

        public static native void SDL_FreeCursor(
                SDL_Cursor cursor);

        @MagicConstant(intValues = { SDL_ENABLE, SDL_DISABLE })
        public static native int SDL_ShowCursor(
                @MagicConstant(intValues = { SDL_ENABLE, SDL_DISABLE, SDL_QUERY }) int toggle);
    }
}
