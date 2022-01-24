package org.libsdl.api.touch;

import com.sun.jna.IntegerType;

public class SDL_TouchID extends IntegerType {

    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_TouchID() {
        super(8, false);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_TouchID(long value) {
        super(8, value, false);
    }
}
