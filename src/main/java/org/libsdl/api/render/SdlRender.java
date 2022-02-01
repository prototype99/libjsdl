package org.libsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.blendmode.SDL_BlendMode;
import org.libsdl.api.rect.SDL_Point;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

public final class SdlRender {

    public static final int SDL_RENDERER_SOFTWARE = 0x00000001;
    public static final int SDL_RENDERER_ACCELERATED = 0x00000002;
    public static final int SDL_RENDERER_PRESENTVSYNC = 0x00000004;
    public static final int SDL_RENDERER_TARGETTEXTURE = 0x00000008;

    public static final int SDL_TEXTUREACCESS_STATIC = 0;
    public static final int SDL_TEXTUREACCESS_STREAMING = 1;
    public static final int SDL_TEXTUREACCESS_TARGET = 2;

    public static final int SDL_TEXTUREMODULATE_NONE = 0x00000000;
    public static final int SDL_TEXTUREMODULATE_COLOR = 0x00000001;
    public static final int SDL_TEXTUREMODULATE_ALPHA = 0x00000002;

    public static final int SDL_FLIP_NONE = 0x00000000;
    public static final int SDL_FLIP_HORIZONTAL = 0x00000001;
    public static final int SDL_FLIP_VERTICAL = 0x00000002;

    static {
        NativeLoader.registerNativeMethods(SdlRender.class);
    }

    private SdlRender() {
    }

    public static native int SDL_GetNumRenderDrivers();

    public static native int SDL_GetRenderDriverInfo(
            int index,
            SDL_RendererInfo info);

    public static native int SDL_CreateWindowAndRenderer(
            int width,
            int height,
            int windowFlags,
            PointerByReference window,
            PointerByReference renderer);

    /**
     * Create a 2D rendering context for a window.
     *
     * @param window the window where rendering is displayed
     * @param index the index of the rendering driver to initialize, or -1 to
     *              initialize the first one supporting the requested flags
     * @param flags 0, or one or more SDL_RendererFlags OR'd together
     * @return a valid rendering context or NULL if there was an error; call
     *         SDL_GetError() for more information.
     *
     * @see #SDL_CreateSoftwareRenderer
     * @see #SDL_DestroyRenderer
     * @see #SDL_GetNumRenderDrivers
     * @see #SDL_GetRendererInfo
     */
    public static native SDL_Renderer SDL_CreateRenderer(
            SDL_Window window,
            int index,
            int flags);

    public static native SDL_Renderer SDL_CreateSoftwareRenderer(
            SDL_Surface surface);

    public static native SDL_Renderer SDL_GetRenderer(
            SDL_Window window);

    public static native int SDL_GetRendererInfo(
            SDL_Renderer renderer,
            SDL_RendererInfo info);

    public static native int SDL_GetRendererOutputSize(
            SDL_Renderer renderer,
            IntByReference w,
            IntByReference h);

    /**
     * <p>Create a texture for a rendering context.</p>
     *
     * <p>You can set the texture scaling method by setting
     * {@code SDL_HINT_RENDER_SCALE_QUALITY} before creating the texture.</p>
     *
     * @param renderer the rendering context
     * @param format one of the enumerated values in SDL_PixelFormatEnum
     * @param access one of the enumerated values in SDL_TextureAccess
     * @param w the width of the texture in pixels
     * @param h the height of the texture in pixels
     * @return a pointer to the created texture or NULL if no rendering context
     *         was active, the format was unsupported, or the width or height
     *         were out of range; call SDL_GetError() for more information.
     *
     * @see #SDL_CreateTextureFromSurface
     * @see #SDL_DestroyTexture
     * @see #SDL_QueryTexture
     * @see #SDL_UpdateTexture
     */
    public static native SDL_Texture SDL_CreateTexture(
            SDL_Renderer renderer,
            int format,
            int access,
            int w,
            int h);

    public static native SDL_Texture SDL_CreateTextureFromSurface(
            SDL_Renderer renderer,
            SDL_Surface surface);

    public static native int SDL_QueryTexture(
            SDL_Texture texture,
            IntByReference format,
            IntByReference access,
            IntByReference w,
            IntByReference h);

    public static native int SDL_SetTextureColorMod(
            SDL_Texture texture,
            byte r,
            byte g,
            byte b);

    public static native int SDL_GetTextureColorMod(
            SDL_Texture texture,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    public static native int SDL_SetTextureAlphaMod(
            SDL_Texture texture,
            byte alpha);

    public static native int SDL_GetTextureAlphaMod(
            SDL_Texture texture,
            ByteByReference alpha);

    public static native int SDL_SetTextureBlendMode(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    public static native int SDL_GetTextureBlendMode(
            SDL_Texture texture,
            SDL_BlendMode.Ref blendMode);

    /**
     * <p>Update the given texture rectangle with new pixel data.</p>
     *
     * <p>The pixel data must be in the pixel format of the texture. Use
     * SDL_QueryTexture() to query the pixel format of the texture.</p>
     *
     * <p>This is a fairly slow function, intended for use with static textures that
     * do not change often.</p>
     *
     * <p>If the texture is intended to be updated often, it is preferred to create
     * the texture as streaming and use the locking functions referenced below.
     * While this function will work with streaming textures, for optimization
     * reasons you may not get the pixels back if you lock the texture afterward.</p>
     *
     * @param texture the texture to update
     * @param rect an SDL_Rect structure representing the area to update, or NULL
     *             to update the entire texture
     * @param pixels the raw pixel data in the format of the texture
     * @param pitch the number of bytes in a row of pixel data, including padding
     *              between lines
     * @return 0 on success or a negative error code on failure; call
     *         SDL_GetError() for more information.
     *
     * @see #SDL_CreateTexture
     * @see #SDL_LockTexture
     * @see #SDL_UnlockTexture
     */
    public static native int SDL_UpdateTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer pixels,
            int pitch);

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static native int SDL_UpdateYUVTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            ByteByReference yPlane,
            int yPitch,
            ByteByReference uPlane,
            int uPitch,
            ByteByReference vPlane,
            int vPitch);

    public static native int SDL_LockTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            PointerByReference pixels,
            IntByReference pitch);

    public static native void SDL_UnlockTexture(
            SDL_Texture texture);

    public static native boolean SDL_RenderTargetSupported(
            SDL_Renderer renderer);

    public static native int SDL_SetRenderTarget(
            SDL_Renderer renderer,
            SDL_Texture texture);

    public static native SDL_Texture SDL_GetRenderTarget(
            SDL_Renderer renderer);

    /**
     * <p>Set a device independent resolution for rendering.</p>
     *
     * <p>This function uses the viewport and scaling functionality to allow a fixed
     * logical resolution for rendering, regardless of the actual output
     * resolution. If the actual output resolution doesn't have the same aspect
     * ratio the output rendering will be centered within the output display.</p>
     *
     * <p>If the output display is a window, mouse and touch events in the window
     * will be filtered and scaled so they seem to arrive within the logical
     * resolution. The SDL_HINT_MOUSE_RELATIVE_SCALING hint controls whether
     * relative motion events are also scaled.</p>
     *
     * <p>If this function results in scaling or subpixel drawing by the rendering
     * backend, it will be handled using the appropriate quality hints.</p>
     *
     * @param renderer the renderer for which resolution should be set
     * @param w the width of the logical resolution
     * @param h the height of the logical resolution
     * @return 0 on success or a negative error code on failure; call
     *         SDL_GetError() for more information.
     *
     * @since This function is available since SDL 2.0.0.
     *
     * @see #SDL_RenderGetLogicalSize
     */
    public static native int SDL_RenderSetLogicalSize(
            SDL_Renderer renderer,
            int w,
            int h);

    public static native void SDL_RenderGetLogicalSize(
            SDL_Renderer renderer,
            IntByReference w,
            IntByReference h);

    /**
     * <p>Set whether to force integer scales for resolution-independent rendering.</p>
     *
     * <p>This function restricts the logical viewport to integer values - that is,
     * when a resolution is between two multiples of a logical size, the viewport
     * size is rounded down to the lower multiple.</p>
     *
     * @param renderer the renderer for which integer scaling should be set
     * @param enable enable or disable the integer scaling for rendering
     * @return 0 on success or a negative error code on failure; call
     *         SDL_GetError() for more information.
     *
     * @since This function is available since SDL 2.0.5.
     *
     * @see #SDL_RenderGetIntegerScale
     * @see #SDL_RenderSetLogicalSize
     */
    public static native int SDL_RenderSetIntegerScale(
            SDL_Renderer renderer,
            boolean enable);

    public static native boolean SDL_RenderGetIntegerScale(
            SDL_Renderer renderer);

    public static native int SDL_RenderSetViewport(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native void SDL_RenderGetViewport(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native int SDL_RenderSetClipRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native void SDL_RenderGetClipRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native boolean SDL_RenderIsClipEnabled(
            SDL_Renderer renderer);

    public static native int SDL_RenderSetScale(
            SDL_Renderer renderer,
            float scaleX,
            float scaleY);

    public static native void SDL_RenderGetScale(
            SDL_Renderer renderer,
            FloatByReference scaleX,
            FloatByReference scaleY);

    public static native int SDL_SetRenderDrawColor(
            SDL_Renderer renderer,
            byte r,
            byte g,
            byte b,
            byte a);

    public static native int SDL_GetRenderDrawColor(
            SDL_Renderer renderer,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b,
            ByteByReference a);

    public static native int SDL_SetRenderDrawBlendMode(
            SDL_Renderer renderer,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    public static native int SDL_GetRenderDrawBlendMode(
            SDL_Renderer renderer,
            SDL_BlendMode.Ref blendMode);

    /**
     * <p>Clear the current rendering target with the drawing color.</p>
     *
     * <p>This function clears the entire rendering target, ignoring the viewport and
     * the clip rectangle.</p>
     *
     * @param renderer the rendering context
     * @return 0 on success or a negative error code on failure; call
     *         SDL_GetError() for more information.
     *
     * @since This function is available since SDL 2.0.0.
     *
     * @see #SDL_SetRenderDrawColor
     */
    public static native int SDL_RenderClear(
            SDL_Renderer renderer);

    public static native int SDL_RenderDrawPoint(
            SDL_Renderer renderer,
            int x,
            int y);

    public static native int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            SDL_Point points,
            int count);

    public static native int SDL_RenderDrawLine(
            SDL_Renderer renderer,
            int x1,
            int y1,
            int x2,
            int y2);

    public static native int SDL_RenderDrawLines(
            SDL_Renderer renderer,
            SDL_Point points,
            int count);

    public static native int SDL_RenderDrawRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native int SDL_RenderDrawRects(
            SDL_Renderer renderer,
            SDL_Rect rects,
            int count);

    public static native int SDL_RenderFillRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native int SDL_RenderFillRects(
            SDL_Renderer renderer,
            SDL_Rect rects,
            int count);

    /**
     * <p>Copy a portion of the texture to the current rendering target.</p>
     *
     * <p>The texture is blended with the destination based on its blend mode set
     * with SDL_SetTextureBlendMode().</p>
     *
     * <p>The texture color is affected based on its color modulation set by
     * SDL_SetTextureColorMod().</p>
     *
     * <p>The texture alpha is affected based on its alpha modulation set by
     * SDL_SetTextureAlphaMod().</p>
     *
     * @param renderer the rendering context
     * @param texture the source texture
     * @param srcrect the source SDL_Rect structure or NULL for the entire texture
     * @param dstrect the destination SDL_Rect structure or NULL for the entire
     *                rendering target; the texture will be stretched to fill the
     *                given rectangle
     * @return 0 on success or a negative error code on failure; call
     *         SDL_GetError() for more information.
     *
     * @see #SDL_RenderCopyEx
     * @see #SDL_SetTextureAlphaMod
     * @see #SDL_SetTextureBlendMode
     * @see #SDL_SetTextureColorMod
     */
    public static native int SDL_RenderCopy(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcrect,
            SDL_Rect dstrect);

    public static native int SDL_RenderCopyEx(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcrect,
            SDL_Rect dstrect,
            double angle,
            SDL_Point center,
            int flip);

    public static native int SDL_RenderReadPixels(
            SDL_Renderer renderer,
            SDL_Rect rect,
            int format,
            Pointer pixels,
            int pitch);

    /**
     * <p>Update the screen with any rendering performed since the previous call.</p>
     *
     * <p>SDL's rendering functions operate on a backbuffer; that is, calling a
     * rendering function such as SDL_RenderDrawLine() does not directly put a
     * line on the screen, but rather updates the backbuffer. As such, you compose
     * your entire scene and *present* the composed backbuffer to the screen as a
     * complete picture.</p>
     *
     * <p>Therefore, when using SDL's rendering API, one does all drawing intended
     * for the frame, and then calls this function once per frame to present the
     * final drawing to the user.</p>
     *
     * <p>The backbuffer should be considered invalidated after each present; do not
     * assume that previous contents will exist between frames. You are strongly
     * encouraged to call SDL_RenderClear() to initialize the backbuffer before
     * starting each new frame's drawing, even if you plan to overwrite every
     * pixel.</p>
     *
     * @param renderer the rendering context
     *
     * @see #SDL_RenderClear
     * @see #SDL_RenderDrawLine
     * @see #SDL_RenderDrawLines
     * @see #SDL_RenderDrawPoint
     * @see #SDL_RenderDrawPoints
     * @see #SDL_RenderDrawRect
     * @see #SDL_RenderDrawRects
     * @see #SDL_RenderFillRect
     * @see #SDL_RenderFillRects
     * @see #SDL_SetRenderDrawBlendMode
     * @see #SDL_SetRenderDrawColor
     */
    public static native void SDL_RenderPresent(
            SDL_Renderer renderer);

    /**
     * <p>Destroy the specified texture.</p>
     *
     * <p>Passing NULL or an otherwise invalid texture will set the SDL error message
     * to "Invalid texture".</p>
     *
     * @param texture the texture to destroy
     *
     * @see #SDL_CreateTexture
     * @see #SDL_CreateTextureFromSurface
     */
    public static native void SDL_DestroyTexture(
            SDL_Texture texture);

    /**
     * Destroy the rendering context for a window and free associated textures.
     *
     * @param renderer the rendering context
     *
     * @see #SDL_CreateRenderer
     */
    public static native void SDL_DestroyRenderer(
            SDL_Renderer renderer);

    public static native int SDL_GL_BindTexture(
            SDL_Texture texture,
            FloatByReference texw,
            FloatByReference texh);

    public static native int SDL_GL_UnbindTexture(
            SDL_Texture texture);

    public static native Pointer SDL_RenderGetMetalLayer(
            SDL_Renderer renderer);

    public static native Pointer SDL_RenderGetMetalCommandEncoder(
            SDL_Renderer renderer);
}
