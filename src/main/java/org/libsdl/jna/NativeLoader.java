package org.libsdl.jna;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import com.sun.jna.DefaultTypeMapper;
import com.sun.jna.FromNativeContext;
import com.sun.jna.Library;
import com.sun.jna.MethodResultContext;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;
import org.libsdl.api.stdinc.SdlReleaseCharRefMemory;

import static org.libsdl.api.stdinc.SdlStdinc.SDL_free;

public final class NativeLoader {

    private NativeLoader() {
    }

    public static void registerNativeMethods(Class<?> nativeClass) {
        NativeLibrary lib = loadSdl2Library();
        Native.register(nativeClass, lib);
    }

    public static NativeLibrary loadSdl2Library() {
        ClassLoader classLoader = NativeLoader.class.getClassLoader();
        Map<String, Object> options = new HashMap<>();
        options.put(Library.OPTION_CLASSLOADER, classLoader);
        DefaultTypeMapper typeMapper = new DefaultTypeMapper();
        typeMapper.addTypeConverter(String.class, new AnnotatedStringFromNativeConverter());
        options.put(Library.OPTION_TYPE_MAPPER, typeMapper);
        return NativeLibrary.getInstance("sdl2", options);
    }

    private static class AnnotatedStringFromNativeConverter implements TypeConverter {

        @Override
        public Object fromNative(Object nativeValue, FromNativeContext context) {
            Pointer returnValue = (Pointer) nativeValue;
            String text = returnValue.getString(0L, "UTF-8");
            Annotation[] annotations = ((MethodResultContext) context).getMethod().getDeclaredAnnotations();
            if (containsAnnotation(annotations, SdlReleaseCharRefMemory.class)) {
                SDL_free(returnValue);
            }
            return text;
        }

        @Override
        public Object toNative(Object value, ToNativeContext context) {
            return value;
        }

        @Override
        public Class<?> nativeType() {
            return Pointer.class;
        }

        private static boolean containsAnnotation(Annotation[] annotations, Class<?> annoClass) {
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().isAssignableFrom(annoClass)) {
                    return true;
                }
            }
            return false;
        }
    }
}
