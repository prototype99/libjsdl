package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "x",
        "y",
        "w",
        "h"
})
/**
 * A rectangle, with the origin at the upper left (integer).
 *
 * @see #SDL_RectEmpty
 * @see #SDL_RectEquals
 * @see #SDL_HasIntersection
 * @see #SDL_IntersectRect
 * @see #SDL_UnionRect
 * @see #SDL_EnclosePoints
 */
public final class SDL_Rect extends JnaStructure {

    public int x;
    public int y;
    public int w;
    public int h;

    public SDL_Rect() {
    }

    public SDL_Rect(Pointer p) {
        super(p);
    }
}
