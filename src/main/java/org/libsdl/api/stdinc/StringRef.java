package org.libsdl.api.stdinc;

import com.sun.jna.FromNativeContext;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

import static org.libsdl.api.stdinc.SdlStdinc.SDL_free;

public class StringRef extends PointerType {

    private String text;

    public StringRef() {
        super(Pointer.NULL);
    }

    public StringRef(String text) {
        super(Pointer.NULL);
        this.text = text;
    }

    @Override
    public Object fromNative(Object nativeValue, FromNativeContext context) {
        Pointer charRef = (Pointer) nativeValue;
        String text = charRef.getString(0L, "UTF-8");
        StringRef result = new StringRef(text);
        SDL_free(charRef);
        return result;
    }

    @Override
    public String toString() {
        return text;
    }
}
