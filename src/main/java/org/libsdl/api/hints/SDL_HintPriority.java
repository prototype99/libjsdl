package org.libsdl.api.hints;

import org.libsdl.jna.JnaEnum;

public final class SDL_HintPriority implements JnaEnum {

    public static final int SDL_HINT_DEFAULT = 0;
    public static final int SDL_HINT_NORMAL = 1;
    public static final int SDL_HINT_OVERRIDE = 2;

    private SDL_HintPriority() {
    }
}
