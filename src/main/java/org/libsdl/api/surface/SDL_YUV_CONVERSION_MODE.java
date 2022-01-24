package org.libsdl.api.surface;

import org.libsdl.jna.JnaEnum;

@SuppressWarnings({"checkstyle:AbbreviationAsWordInName", "checkstyle:TypeName"})
public final class SDL_YUV_CONVERSION_MODE implements JnaEnum {

    /**
     * Full range JPEG
     */
    public static final int SDL_YUV_CONVERSION_JPEG = 0;

    /**
     * BT.601 (the default)
     */
    public static final int SDL_YUV_CONVERSION_BT601 = 1;

    /**
     * BT.709
     */
    public static final int SDL_YUV_CONVERSION_BT709 = 2;

    /**
     * BT.601 for SD content, BT.709 for HD content
     */
    public static final int SDL_YUV_CONVERSION_AUTOMATIC = 3;

    private SDL_YUV_CONVERSION_MODE() {
    }
}
