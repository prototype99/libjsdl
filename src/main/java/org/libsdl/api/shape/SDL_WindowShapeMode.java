package org.libsdl.api.shape;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.shape.WindowShapeMode.SHAPE_MODE_BINARIZE_ALPHA;
import static org.libsdl.api.shape.WindowShapeMode.SHAPE_MODE_COLOR_KEY;
import static org.libsdl.api.shape.WindowShapeMode.SHAPE_MODE_DEFAULT;
import static org.libsdl.api.shape.WindowShapeMode.SHAPE_MODE_REVERSE_BINARIZE_ALPHA;

@Structure.FieldOrder({
        "mode",
        "parameters"
})
public class SDL_WindowShapeMode extends Structure {

    @MagicConstant(valuesFromClass = WindowShapeMode.class)
    public int mode;
    public SDL_WindowShapeParams parameters;

    /**
     * Reads the fields of the struct from native memory
     */
    @Override
    public void read() {
        readField("mode");
        switch (mode) {
            case SHAPE_MODE_DEFAULT:
            case SHAPE_MODE_BINARIZE_ALPHA:
            case SHAPE_MODE_REVERSE_BINARIZE_ALPHA:
                parameters.setType("binarizationCutoff");
                break;
            case SHAPE_MODE_COLOR_KEY:
                parameters.setType("colorKey");
                break;
            default:
                throw new IllegalStateException("Unknown mode " + mode);
        }
        super.read();
    }
}
