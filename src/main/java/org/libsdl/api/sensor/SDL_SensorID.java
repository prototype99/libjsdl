package org.libsdl.api.sensor;

import com.sun.jna.IntegerType;

/**
 * This is a unique ID for a sensor for the time it is connected to the system,
 * and is never reused for the lifetime of the application.
 *
 * The ID value starts at 0 and increments from there. The value -1 is an invalid ID.
 */
public class SDL_SensorID extends IntegerType {

    /**
     * Create a zero-valued signed IntegerType.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_SensorID() {
        super(4);
    }

    /**
     * Create a signed IntegerType with the given value.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public SDL_SensorID(int value) {
        super(4, value);
    }

    /**
     * Change the value for this data.
     *
     * @param value value to set
     */
    public void setValue(int value) {
        super.setValue(value);
    }
}
