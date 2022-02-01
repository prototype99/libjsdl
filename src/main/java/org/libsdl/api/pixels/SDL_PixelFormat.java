package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

@Structure.FieldOrder({
        "format",
        "palette",
        "bitsPerPixel",
        "bytesPerPixel",
        "padding",
        "rMask",
        "gMask",
        "bMask",
        "aMask",
        "rLoss",
        "gLoss",
        "bLoss",
        "aLoss",
        "rShift",
        "gShift",
        "bShift",
        "aShift",
        "refcount",
        "next"
})
/**
 * @apiNote Everything in the pixel format structure is read-only.
 */
public class SDL_PixelFormat extends Structure {

    // TODO: Check suspicious padding
    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public int format;
    public SDL_Palette.ByReference palette;
    public byte bitsPerPixel;
    public byte bytesPerPixel;
    public byte[] padding = new byte[2];
    public int rMask;
    public int gMask;
    public int bMask;
    public int aMask;
    public byte rLoss;
    public byte gLoss;
    public byte bLoss;
    public byte aLoss;
    public byte rShift;
    public byte gShift;
    public byte bShift;
    public byte aShift;
    public int refcount;
    public Pointer next;

    public static final class ByReference extends SDL_PixelFormat implements Structure.ByReference {
    }
}
