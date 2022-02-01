package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "sensor",
        "data"
})
//Sensor event structure (event.sensor.*)
public final class SDL_SensorEvent extends SDL_JoyDeviceEvent {
    private static final int BUF_SIZE = 6;
    //Up to 6 values from the sensor - additional values can be queried using SDL_SensorGetData()
    public float[] data = new float[BUF_SIZE];
}