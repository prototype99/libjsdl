package org.libsdl.api.event;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.api.event.events.SDL_Event;

@FunctionalInterface
/*
  A function pointer used for callbacks that watch the event queue.

  @param userdata what was passed as {@code userdata} to SDL_SetEventFilter()
 *                 or SDL_AddEventWatch, etc
 * @param event the event that triggered the callback
 * @return 1 to permit event to be added to the queue, and 0 to disallow
 *         it. When used with SDL_AddEventWatch, the return value is ignored.
 *
 * @see #SDL_SetEventFilter
 * @see #SDL_AddEventWatch
 */
public interface SDL_EventFilter extends Callback {
    int callback(
            Pointer userdata,
            SDL_Event event);
}
