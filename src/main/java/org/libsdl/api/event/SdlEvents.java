package org.libsdl.api.event;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import org.libsdl.api.event.events.SDL_Event;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings("checkstyle:DeclarationOrder")
public final class SdlEvents {

    public static final int SDL_RELEASED = 0;
    public static final int SDL_PRESSED = 1;

    /******
     * SDL_EventType
     ******/
    /** Unused (do not remove) */
    public static final int SDL_FIRSTEVENT = 0;

    /* Application events */
    /**< User-requested quit */
    public static final int SDL_QUIT = 0x100;
    /* These application events have special meaning on iOS, see README-ios.md for details */
    /**< The application is being terminated by the OS
     Called on iOS in applicationWillTerminate()
     Called on Android in onDestroy()
     */
    public static final int SDL_APP_TERMINATING = 0x101;
    /**< The application is low on memory, free memory if possible.
     Called on iOS in applicationDidReceiveMemoryWarning()
     Called on Android in onLowMemory()
     */
    public static final int SDL_APP_LOWMEMORY = 0x102;
    /**< The application is about to enter the background
     Called on iOS in applicationWillResignActive()
     Called on Android in onPause()
     */
    public static final int SDL_APP_WILLENTERBACKGROUND = 0x103;
    /**< The application did enter the background and may not get CPU for some time
     Called on iOS in applicationDidEnterBackground()
     Called on Android in onPause()
     */
    public static final int SDL_APP_DIDENTERBACKGROUND = 0x104;
    /**< The application is about to enter the foreground
     Called on iOS in applicationWillEnterForeground()
     Called on Android in onResume()
     */
    public static final int SDL_APP_WILLENTERFOREGROUND = 0x105;
    /**< The application is now interactive
     Called on iOS in applicationDidBecomeActive()
     Called on Android in onResume()
     */
    public static final int SDL_APP_DIDENTERFOREGROUND = 0x106;
    //< The user's locale preferences have changed.
    public static final int SDL_LOCALECHANGED = 0x107;

    /* Display events */
    /**< Display state change */
    public static final int SDL_DISPLAYEVENT = 0x150;

    /* Window events */
    /**< Window state change */
    public static final int SDL_WINDOWEVENT = 0x200;
    /**< System specific event */
    public static final int SDL_SYSWMEVENT = 0x201;

    /* Keyboard events */
    /**< Key pressed */
    public static final int SDL_KEYDOWN = 0x300;
    /**< Key released */
    public static final int SDL_KEYUP = 0x301;
    /**< Keyboard text editing (composition) */
    public static final int SDL_TEXTEDITING = 0x302;
    /**< Keyboard text input */
    public static final int SDL_TEXTINPUT = 0x303;
    /**< Keymap changed due to a system event such as an
     input language or keyboard layout change.
     */
    public static final int SDL_KEYMAPCHANGED = 0x304;

    /* Mouse events */
    /**< Mouse moved */
    public static final int SDL_MOUSEMOTION = 0x400;
    /**< Mouse button pressed */
    public static final int SDL_MOUSEBUTTONDOWN = 0x401;
    /**< Mouse button released */
    public static final int SDL_MOUSEBUTTONUP = 0x402;
    /**< Mouse wheel motion */
    public static final int SDL_MOUSEWHEEL = 0x403;

    /* Joystick events */
    /**< Joystick axis motion */
    public static final int SDL_JOYAXISMOTION = 0x600;
    /**< Joystick trackball motion */
    public static final int SDL_JOYBALLMOTION = 0x601;
    /**< Joystick hat position change */
    public static final int SDL_JOYHATMOTION = 0x602;
    /**< Joystick button pressed */
    public static final int SDL_JOYBUTTONDOWN = 0x603;
    /**< Joystick button released */
    public static final int SDL_JOYBUTTONUP = 0x604;
    /**< A new joystick has been inserted into the system */
    public static final int SDL_JOYDEVICEADDED = 0x605;
    /**< An opened joystick has been removed */
    public static final int SDL_JOYDEVICEREMOVED = 0x606;

    /* Game controller events */
    /**< Game controller axis motion */
    public static final int SDL_CONTROLLERAXISMOTION = 0x650;
    /**< Game controller button pressed */
    public static final int SDL_CONTROLLERBUTTONDOWN = 0x651;
    /**< Game controller button released */
    public static final int SDL_CONTROLLERBUTTONUP = 0x652;
    /**< A new Game controller has been inserted into the system */
    public static final int SDL_CONTROLLERDEVICEADDED = 0x653;
    /**< An opened Game controller has been removed */
    public static final int SDL_CONTROLLERDEVICEREMOVED = 0x654;
    /**< The controller mapping was updated */
    public static final int SDL_CONTROLLERDEVICEREMAPPED = 0x655;
    //< Game controller touchpad was touched
    public static final int SDL_CONTROLLERTOUCHPADDOWN = 0x656;
    //< Game controller touchpad finger was moved
    public static final int SDL_CONTROLLERTOUCHPADMOTION = 0x657;
    //< Game controller touchpad finger was lifted
    public static final int SDL_CONTROLLERTOUCHPADUP = 0x658;
    //< Game controller sensor was updated
    public static final int SDL_CONTROLLERSENSORUPDATE = 0x659;

    /* Touch events */
    public static final int SDL_FINGERDOWN = 0x700;
    public static final int SDL_FINGERUP = 0x701;
    public static final int SDL_FINGERMOTION = 0x702;

    /* Gesture events */
    public static final int SDL_DOLLARGESTURE = 0x800;
    public static final int SDL_DOLLARRECORD = 0x801;
    public static final int SDL_MULTIGESTURE = 0x802;

    /* Clipboard events */
    /**< The clipboard changed */
    public static final int SDL_CLIPBOARDUPDATE = 0x900;

    /* Drag and drop events */
    /**< The system requests a file open */
    public static final int SDL_DROPFILE = 0x1000;
    /**< text/plain drag-and-drop event */
    public static final int SDL_DROPTEXT = 0x1001;
    /**< A new set of drops is beginning (NULL filename) */
    public static final int SDL_DROPBEGIN = 0x1002;
    /**< Current set of drops is now complete (NULL filename) */
    public static final int SDL_DROPCOMPLETE = 0x1003;

    /* Audio hotplug events */
    /**< A new audio device is available */
    public static final int SDL_AUDIODEVICEADDED = 0x1100;
    /**< An audio device has been removed. */
    public static final int SDL_AUDIODEVICEREMOVED = 0x1101;

    /* Sensor events */
    /**< A sensor was updated */
    public static final int SDL_SENSORUPDATE = 0x1200;

    /* Render events */
    /**< The render targets have been reset and their contents need to be updated */
    public static final int SDL_RENDER_TARGETS_RESET = 0x2000;
    /**< The device has been reset and all textures need to be recreated */
    public static final int SDL_RENDER_DEVICE_RESET = 0x2001;

    /** Events ::USEREVENT through ::LASTEVENT are for your use,
     *  and should be allocated with RegisterEvents()
     */
    public static final int SDL_USEREVENT = 0x8000;

    /**
     *  This last event is only for bounding internal arrays
     */
    public static final int SDL_LASTEVENT = 0xFFFF;

    /******
     * SDL_eventaction
     ******/
    public static final int SDL_ADDEVENT = 0;
    public static final int SDL_PEEKEVENT = 1;
    public static final int SDL_GETEVENT = 2;

    static {
        NativeLoader.registerNativeMethods(SdlEvents.class);
    }

    private SdlEvents() {
    }

    /**
     * <p>Pump the event loop, gathering events from the input devices.</p>
     *
     * <p>This function updates the event queue and internal input device state.</p>
     *
     * <p><b>WARNING</b>: This should only be run in the thread that initialized the
     * video subsystem, and for extra safety, you should consider only doing those
     * things on the main thread in any case.</p>
     *
     * <p>SDL_PumpEvents() gathers all the pending input information from devices and
     * places it in the event queue. Without calls to SDL_PumpEvents() no events
     * would ever be placed on the queue. Often the need for calls to
     * SDL_PumpEvents() is hidden from the user since SDL_PollEvent() and
     * SDL_WaitEvent() implicitly call SDL_PumpEvents(). However, if you are not
     * polling or waiting for events (e.g. you are filtering them), then you must
     * call SDL_PumpEvents() to force an event queue update.</p>
     *
     * @see #SDL_PollEvent
     * @see #SDL_WaitEvent
     */
    public static native void SDL_PumpEvents();

    /**
     * <p>Check the event queue for messages and optionally return them.</p>
     *
     * <p>{@code action} may be any of the following:</p>
     *
     * <ul>
     *   <li>{@code SDL_ADDEVENT}: up to {@code numevents} events will be added to the back of the
     *       event queue.</li>
     *   <li>{@code SDL_PEEKEVENT}: {@code numevents} events at the front of the event queue,
     *       within the specified minimum and maximum type, will be returned to the
     *       caller and will <i>not</i> be removed from the queue.</li>
     *   <li>{@code SDL_GETEVENT}: up to {@code numevents} events at the front of the event queue,
     *       within the specified minimum and maximum type, will be returned to the
     *       caller and will be removed from the queue.</li>
     *</ul>
     * <p>You may have to call SDL_PumpEvents() before calling this function.
     * Otherwise, the events may not be ready to be filtered when you call
     * SDL_PeepEvents().</p>
     *
     * <p>This function is thread-safe.</p>
     *
     * @param events destination buffer for the retrieved events
     * @param numevents if action is SDL_ADDEVENT, the number of events to add
     *                  back to the event queue; if action is SDL_PEEKEVENT or
     *                  SDL_GETEVENT, the maximum number of events to retrieve
     * @param action action to take; see [[#action|Remarks]] for details
     * @param minType minimum value of the event type to be considered;
     *                SDL_FIRSTEVENT is a safe choice
     * @param maxType maximum value of the event type to be considered;
     *                SDL_LASTEVENT is a safe choice
     * @return the number of events actually stored or a negative error code on
     *         failure; call SDL_GetError() for more information.
     *
     * @see #SDL_PollEvent
     * @see #SDL_PumpEvents
     * @see #SDL_PushEvent
     */
    public static native int SDL_PeepEvents(
            Pointer events,
            int numevents,
            int action,
            int minType,
            int maxType);

    public static native boolean SDL_HasEvent(
            int type);

    public static native boolean SDL_HasEvents(
            int minType,
            int maxType);

    public static native void SDL_FlushEvent(
            int type);

    public static native void SDL_FlushEvents(
            int minType,
            int maxType);

    public static native int SDL_PollEvent(
            SDL_Event event);

    public static native int SDL_WaitEvent(
            SDL_Event event);

    public static native int SDL_WaitEventTimeout(
            SDL_Event event,
            int timeout);

    /**
     * <p>Add an event to the event queue.</p>
     *
     * <p>The event queue can actually be used as a two way communication channel.
     * Not only can events be read from the queue, but the user can also push
     * their own events onto it. {@code event} is a pointer to the event structure you
     * wish to push onto the queue. The event is copied into the queue, and the
     * caller may dispose of the memory pointed to after SDL_PushEvent() returns.</p>
     *
     * <p>Note: Pushing device input events onto the queue doesn't modify the state
     * of the device within SDL.</p>
     *
     * <p>This function is thread-safe, and can be called from other threads safely.</p>
     *
     * <p>Note: Events pushed onto the queue with SDL_PushEvent() get passed through
     * the event filter but events added with SDL_PeepEvents() do not.</p>
     *
     * <p>For pushing application-specific events, please use SDL_RegisterEvents() to
     * get an event type that does not conflict with other code that also wants
     * its own custom event types.</p>
     *
     * @param event the SDL_Event to be added to the queue
     * @return 1 on success, 0 if the event was filtered, or a negative error
     *         code on failure; call SDL_GetError() for more information. A
     *         common reason for error is the event queue being full.
     *
     * @see #SDL_PeepEvents
     * @see #SDL_PollEvent
     * @see #SDL_RegisterEvents
     */
    public static native int SDL_PushEvent(
            SDL_Event event);

    /**
     * <p>Set up a filter to process all events before they change internal state and
     * are posted to the internal event queue.</p>
     *
     * <p>If the filter function returns 1 when called, then the event will be added
     * to the internal queue. If it returns 0, then the event will be dropped from
     * the queue, but the internal state will still be updated. This allows
     * selective filtering of dynamically arriving events.</p>
     *
     * <p><b>WARNING</b>: Be very careful of what you do in the event filter function,
     * as it may run in a different thread!</p>
     *
     * <p>On platforms that support it, if the quit event is generated by an
     * interrupt signal (e.g. pressing Ctrl-C), it will be delivered to the
     * application at the next event poll.</p>
     *
     * <p>There is one caveat when dealing with the ::SDL_QuitEvent event type. The
     * event filter is only called when the window manager desires to close the
     * application window. If the event filter returns 1, then the window will be
     * closed, otherwise the window will remain open if possible.</p>
     *
     * <p>Note: Disabled events never make it to the event filter function; see
     * SDL_EventState().</p>
     *
     * <p>Note: If you just want to inspect events without filtering, you should use
     * SDL_AddEventWatch() instead.</p>
     *
     * <p>Note: Events pushed onto the queue with SDL_PushEvent() get passed through
     * the event filter, but events pushed onto the queue with SDL_PeepEvents() do
     * not.</p>
     *
     * @param filter An SDL_EventFilter function to call when an event happens
     * @param userdata a pointer that is passed to {@code filter}
     *
     * @see #SDL_AddEventWatch
     * @see #SDL_EventState
     * @see #SDL_GetEventFilter
     * @see #SDL_PeepEvents
     * @see #SDL_PushEvent
     */
    public static native void SDL_SetEventFilter(
            SDL_EventFilter filter,
            Pointer userdata);

    public static native boolean SDL_GetEventFilter(
            PointerByReference filter,
            PointerByReference userdata);

    /**
     * <p>Add a callback to be triggered when an event is added to the event queue.</p>
     *
     * <p>{@code filter} will be called when an event happens, and its return value is
     * ignored.</p>
     *
     * <b>WARNING</b>: Be very careful of what you do in the event filter function,
     * as it may run in a different thread!
     *
     * <p>If the quit event is generated by a signal (e.g. SIGINT), it will bypass
     * the internal queue and be delivered to the watch callback immediately, and
     * arrive at the next event poll.</p>
     *
     * <p>Note: the callback is called for events posted by the user through
     * SDL_PushEvent(), but not for disabled events, nor for events by a filter
     * callback set with SDL_SetEventFilter(), nor for events posted by the user
     * through SDL_PeepEvents().</p>
     *
     * @param filter an SDL_EventFilter function to call when an event happens.
     * @param userdata a pointer that is passed to {@code filter}
     *
     * @see #SDL_DelEventWatch
     * @see #SDL_SetEventFilter
     */
    public static native void SDL_AddEventWatch(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * <p>Remove an event watch callback added with SDL_AddEventWatch().</p>
     *
     * <p>This function takes the same input as SDL_AddEventWatch() to identify and
     * delete the corresponding callback.</p>
     *
     * @param filter the function originally passed to SDL_AddEventWatch()
     * @param userdata the pointer originally passed to SDL_AddEventWatch()
     *
     * @see #SDL_AddEventWatch
     */
    public static native void SDL_DelEventWatch(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * <p>Run a specific filter function on the current event queue, removing any
     * events for which the filter returns 0.</p>
     *
     * <p>See SDL_SetEventFilter() for more information. Unlike SDL_SetEventFilter(),
     * this function does not change the filter permanently, it only uses the
     * supplied filter until this function returns.</p>
     *
     * @param filter the SDL_EventFilter function to call when an event happens
     * @param userdata a pointer that is passed to {@code filter}
     *
     * @see #SDL_GetEventFilter
     * @see #SDL_SetEventFilter
     */
    public static native void SDL_FilterEvents(
            SDL_EventFilter filter,
            Pointer userdata);

    public static final int SDL_QUERY = -1;
    public static final int SDL_IGNORE = 0;
    public static final int SDL_DISABLE = 0;
    public static final int SDL_ENABLE = 1;

    /**
     * <p>Set the state of processing events by type.</p>
     *
     * <p>{@code state} may be any of the following:</p>
     *
     * <ul>
     *   <li>{@code SDL_QUERY}: returns the current processing state of the specified event</li>
     *   <li>{@code SDL_IGNORE} (aka {@code SDL_DISABLE}): the event will automatically be dropped</li>
     *       from the event queue and will not be filtered
     *   <li>{@code SDL_ENABLE}: the event will be processed normally</li>
     * </ul>
     *
     * @param type the type of event; see SDL_EventType for details
     * @param state how to process the event
     * @return {@code SDL_DISABLE} or {@code SDL_ENABLE}, representing the processing state
     *          of the event before this function makes any changes to it.
     *
     * @see #SDL_GetEventState
     */
    public static native byte SDL_EventState(
            int type,
            int state);

    public static byte SDL_GetEventState(
            int type) {
        return SDL_EventState(type, SDL_QUERY);
    }

    public static native int SDL_RegisterEvents(
            int numevents);
}
