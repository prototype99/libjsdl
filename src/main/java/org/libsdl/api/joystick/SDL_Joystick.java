package org.libsdl.api.joystick;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * The joystick structure used to identify an SDL joystick
 */
public final class SDL_Joystick extends PointerType {

    /**
     * The default constructor wraps a NULL pointer.
     */
    public SDL_Joystick() {
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     *
     * @param p
     */
    public SDL_Joystick(Pointer p) {
        super(p);
    }
}
