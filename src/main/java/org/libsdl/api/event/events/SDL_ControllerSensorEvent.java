package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "sensor",
        "data"
})
/*
 *  \brief Game controller sensor event structure (event.csensor.*)
 */
public final class SDL_ControllerSensorEvent extends SDL_JoyDeviceEvent {
    private static final int BUF_SIZE = 3;
    //< The type of the sensor, one of the values of ::SDL_SensorType
    public int sensor;
    //< Up to 3 values from the sensor, as defined in SDL_sensor.h
    public float[] data = new float[BUF_SIZE];
}