package org.libsdl.api.rect;

import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "x",
        "y"
})
/**
 * The structure that defines a point (integer)
 *
 * @see #SDL_EnclosePoints
 * @see #SDL_PointInRect
 */
public final class SDL_Point extends JnaStructure {

    public int x;
    public int y;
}
