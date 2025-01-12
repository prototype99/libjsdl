package org.libsdl.api.gamecontroller;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * <p>The gamecontroller structure used to identify an SDL game controller.</p>
 */
public class SDL_GameController extends PointerType {

    /**
     * The default constructor wraps a NULL pointer.
     */
    public SDL_GameController() {
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     *
     * @param p
     */
    public SDL_GameController(Pointer p) {
        super(p);
    }
}
