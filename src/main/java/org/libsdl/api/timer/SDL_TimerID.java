package org.libsdl.api.timer;

import com.sun.jna.IntegerType;

public final class SDL_TimerID extends IntegerType {

    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_TimerID() {
        super(4);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_TimerID(int value) {
        super(4, value);
    }

    public void setValue(int value) {
        super.setValue(value);
    }
}
