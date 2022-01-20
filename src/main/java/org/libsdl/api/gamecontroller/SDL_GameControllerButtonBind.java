package org.libsdl.api.gamecontroller;

import com.sun.jna.Structure;
import com.sun.jna.Union;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.gamecontroller.SDL_GameControllerBindType.SDL_CONTROLLER_BINDTYPE_AXIS;
import static org.libsdl.api.gamecontroller.SDL_GameControllerBindType.SDL_CONTROLLER_BINDTYPE_BUTTON;
import static org.libsdl.api.gamecontroller.SDL_GameControllerBindType.SDL_CONTROLLER_BINDTYPE_HAT;

/**
 * Get the SDL joystick layer binding for this controller button/axis mapping
 */
@Structure.FieldOrder({
        "bindType",
        "value"
})
public class SDL_GameControllerButtonBind extends Structure {

    @MagicConstant(valuesFromClass = SDL_GameControllerBindType.class)
    public int bindType;
    public Value value;

    @Override
    public void read() {
        readField("bindType");
        switch (bindType) {
            case SDL_CONTROLLER_BINDTYPE_BUTTON:
                value.setType("button");
                break;
            case SDL_CONTROLLER_BINDTYPE_AXIS:
                value.setType("axis");
                break;
            case SDL_CONTROLLER_BINDTYPE_HAT:
                value.setType("hat");
                break;
            default:
                System.out.println("Invalid bind type detected");
        }
        super.read();
    }

    public static final class Value extends Union {

        public int button;
        public int axis;
        public Hat hat;
    }

    @Structure.FieldOrder({
            "hat",
            "hatMask"
    })
    public static final class Hat extends Structure {

        public int hat;
        public int hatMask;
    }
}
