package org.libsdl.api.keycode;

public final class SdlKeycode {

    private SdlKeycode() {
    }

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static int SDL_SCANCODE_TO_KEYCODE(
            int x) {
        return x | SdlKeycodeConst.SDLK_SCANCODE_MASK;
    }
}
