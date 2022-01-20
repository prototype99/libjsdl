package org.libsdl.jna;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.ptr.ByReference;

import static org.libsdl.api.endian.SdlEndianConst.SDL_BIG_ENDIAN;
import static org.libsdl.api.endian.SdlEndianConst.SDL_BYTEORDER;
import static org.libsdl.api.endian.SdlEndianConst.SDL_LIL_ENDIAN;

/**
 * <p>'size_t' C type (32 bits on 32 bits platforms, 64 bits on 64 bits platforms).
 * Can be also used to model the 'long' C type for libraries known to be compiled with GCC or LLVM even on Windows.
 * (NativeLong on Windows is only okay with MSVC++ libraries, as 'long' on Windows 64 bits will be 32 bits with MSVC++ and 64 bits with GCC/mingw)</p>
 *
 * <p>Note: Taken from com.sun.jna.Structure.FFIType.size_t</p>
 */
public class SizeT extends IntegerType {

    /** Size of a size_t integer, in bytes. */
    public static int size = Native.SIZE_T_SIZE;
    //Platform.is64Bit() ? 8 : 4;

    private static final long serialVersionUID = 2398288011955445078L;

    /** Create a zero-valued Size. */
    public SizeT() {
        this(0L);
    }

    /** Create a Size with the given value. */
    public SizeT(long value) {
        super(size, value);
    }

    public static final class Ref extends ByReference {

        /**
         * Allocates memory at this pointer, to contain the pointed-to value.
         */
        public Ref() {
            super(SizeT.size);
        }

        public Ref(SizeT initialValue) {
            super(SizeT.size);
            this.setValue(initialValue);
        }

        @SuppressWarnings("checkstyle:MagicNumber")
        public void setValue(SizeT newValue) {
            long currentValue = newValue.longValue();
            if (size == 4) {
                getPointer().setInt(0L, (int) currentValue);
            } else if (size == 8) {
                getPointer().setLong(0L, currentValue);
            } else {
                switch (SDL_BYTEORDER) {
                    case SDL_LIL_ENDIAN:
                        for (long i = 0; i < size; i++) {
                            getPointer().setByte(i, (byte) (currentValue & 0xFF));
                            currentValue = currentValue >> 8;
                        }
                        break;
                    case SDL_BIG_ENDIAN:
                        for (long i = size - 1; i >= 0; i--) {
                            getPointer().setByte(i, (byte) (currentValue & 0xFF));
                            currentValue = currentValue >> 8;
                        }
                        break;
                    default:
                        this.throwException();
                }
            }
        }

        @SuppressWarnings("checkstyle:MagicNumber")
        public SizeT getValue() {
            long currentValue = 0L;
            int rotation = 0;
            switch (SDL_BYTEORDER) {
                case SDL_LIL_ENDIAN:
                    for (long i = 0; i < size; i++) {
                        currentValue += (getPointer().getByte(i) & 0xFFL) << rotation;
                        rotation = rotation + 8;
                    }
                    break;
                case SDL_BIG_ENDIAN:
                    for (long i = size - 1; i >= 0; i--) {
                        currentValue += (getPointer().getByte(i) & 0xFFL) << rotation;
                        rotation = rotation + 8;
                    }
                    break;
                default:
                    this.throwException();
            }
            return new SizeT(currentValue);
        }

        private void throwException() {
            throw new IllegalStateException("Endianness of the platform has not been defined");
        }
    }
}
