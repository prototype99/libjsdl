package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

@Structure.FieldOrder({
        "size",
        "seek",
        "read",
        "write",
        "close",
        "type",
        "hidden"
})
public final class SDL_RWops extends Structure {

    /**
     * Unknown stream type
     */
    public static final int SDL_RWOPS_UNKNOWN = 0;

    /**
     * Win32 file
     */
    public static final int SDL_RWOPS_WINFILE = 1;

    /**
     * Stdio file
     */
    public static final int SDL_RWOPS_STDFILE = 2;

    /**
     * Android asset
     */
    public static final int SDL_RWOPS_JNIFILE = 3;

    /**
     * Memory stream
     */
    public static final int SDL_RWOPS_MEMORY = 4;

    /**
     * Read-Only memory stream
     */
    public static final int SDL_RWOPS_MEMORY_RO = 5;

    /**
     * Vita file
     */
    public static final int SDL_RWOPS_VITAFILE = 6;

    public SDL_RWSizeFunction size;
    public SDL_RWSeekFunction seek;
    public SDL_RWReadFunction read;
    public SDL_RWWriteFunction write;
    public SDL_RWCloseFunction close;
    @MagicConstant(valuesFromClass = SDL_RWops.class)
    public int type;
    public SDL_RWopsPlatformSpecific hidden;

    public SDL_RWops() {
    }

    public SDL_RWops(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        super.readField("type");
        switch (this.type) {
            case SDL_RWOPS_WINFILE:
                this.hidden.setType(SDL_RWopsWindowsIO.class);
                break;
            case SDL_RWOPS_STDFILE:
                this.hidden.setType(SDL_RWopsStdIO.class);
                break;
            case SDL_RWOPS_JNIFILE:
                this.hidden.setType(SDL_RWopsAndroidIO.class);
                break;
            case SDL_RWOPS_MEMORY:
            case SDL_RWOPS_MEMORY_RO:
                this.hidden.setType(SDL_RWopsMemoryIO.class);
                break;
            case SDL_RWOPS_VITAFILE:
                this.hidden.setType(SDL_RWopsVitaIO.class);
                break;
            case SDL_RWOPS_UNKNOWN:
            default:
                this.hidden.setType(SDL_RWopsUnknownIO.class);
                break;
        }
        super.read();
    }
}
