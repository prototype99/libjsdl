package org.libsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "sensor",
        "data"
})
/*
 *  \brief Game controller sensor event structure (event.csensor.*)
 */
public final class SDL_ControllerSensorEvent extends Structure {

    //< ::SDL_CONTROLLERSENSORUPDATE
    public int type;
    //< In milliseconds, populated using SDL_GetTicks()
    public int timestamp;
    //< The joystick instance id
    public NativeLong which;
    //< The type of the sensor, one of the values of ::SDL_SensorType
    public int sensor;
    //< Up to 3 values from the sensor, as defined in SDL_sensor.h
    public float[] data = new float[3];
}