package org.libsdl.api.blendmode;

import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaEnum;

public final class SDL_BlendMode implements JnaEnum {

    public static final int SDL_BLENDMODE_NONE = 0x00000000;
    public static final int SDL_BLENDMODE_BLEND = 0x00000001;
    public static final int SDL_BLENDMODE_ADD = 0x00000002;
    public static final int SDL_BLENDMODE_MOD = 0x00000004;
    public static final int SDL_BLENDMODE_MUL = 0x00000008;
    public static final int SDL_BLENDMODE_INVALID = 0x7FFFFFFF;

    private SDL_BlendMode() {
    }

    public static final class Ref extends IntByReference {

        public Ref() {
        }

        public Ref(int ordinal) {
            super(ordinal);
        }

        @Override
        public void setValue(@MagicConstant(valuesFromClass = SDL_BlendMode.class) int value) {
            super.setValue(value);
        }

        @Override
        @SuppressWarnings("MagicConstant")
        @MagicConstant(valuesFromClass = SDL_BlendMode.class)
        public int getValue() {
            return super.getValue();
        }
    }
}
