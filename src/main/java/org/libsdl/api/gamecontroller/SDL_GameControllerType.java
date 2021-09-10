package org.libsdl.api.gamecontroller;

import org.libsdl.jna.JnaEnum;

public final class SDL_GameControllerType implements JnaEnum {

    public static final int SDL_CONTROLLER_TYPE_UNKNOWN = 0;
    public static final int SDL_CONTROLLER_TYPE_XBOX360 = 1;
    public static final int SDL_CONTROLLER_TYPE_XBOXONE = 2;
    public static final int SDL_CONTROLLER_TYPE_PS3 = 3;
    public static final int SDL_CONTROLLER_TYPE_PS4 = 4;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_PRO = 5;
    public static final int SDL_CONTROLLER_TYPE_VIRTUAL = 6;
    public static final int SDL_CONTROLLER_TYPE_PS5 = 7;
    public static final int SDL_CONTROLLER_TYPE_AMAZON_LUNA = 8;
    public static final int SDL_CONTROLLER_TYPE_GOOGLE_STADI = 9;

    private SDL_GameControllerType() {
    }
}