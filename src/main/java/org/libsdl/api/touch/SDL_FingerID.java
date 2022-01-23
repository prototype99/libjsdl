package org.libsdl.api.touch;

import com.sun.jna.IntegerType;

public class SDL_FingerID extends IntegerType {

    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_FingerID() {
        super(8, false);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_FingerID(long value) {
        super(8, value, false);
    }
}
