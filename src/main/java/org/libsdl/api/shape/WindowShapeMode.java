package org.libsdl.api.shape;

import org.libsdl.jna.JnaEnum;

public final class WindowShapeMode implements JnaEnum {

    public static final int SHAPE_MODE_DEFAULT = 0;
    public static final int SHAPE_MODE_BINARIZE_ALPHA = 1;
    public static final int SHAPE_MODE_REVERSE_BINARIZE_ALPHA = 2;
    public static final int SHAPE_MODE_COLOR_KEY = 4;

    private WindowShapeMode() {
    }
}
