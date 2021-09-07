package org.libsdl.api.filesystem;

import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.libsdl.api.SDL_SubSystem.SDL_INIT_VIDEO;
import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
//import static org.libsdl.api.filesystem.SdlFilesystem.SDL_GetBasePath;
import static org.libsdl.api.filesystem.SdlFilesystem.SDL_GetPrefPath;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;

class SdlFilesystemTest {

    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    @Test
    public void basePathShouldBeValid() {
        int allocCount = SDL_GetNumAllocations();
        System.out.println(allocCount);

//        Path actualBasePath = Paths.get(SDL_GetBasePath());
//        Path expectedBasePath = Paths.get(System.getProperty("java.home"), "bin");
//        assertEquals(expectedBasePath, actualBasePath);
//        System.out.println(actualBasePath);

//        Object basePath = SDL_GetBasePath();
//        String basePathStr = basePath.toString();
//        SDL_free(basePath.getPointer());
//        System.out.println(basePath);

//        Paths.get(basePath.toString());

        Object prefPath = SDL_GetPrefPath("Shine", "LaserApp");
        System.out.println(prefPath);

        int allocCount2 = SDL_GetNumAllocations();
        System.out.println(allocCount2);
        assertEquals(allocCount, allocCount2);
    }

//    @Test
//    public void basePathShouldBeValid() {
//        Path actualBasePath = Paths.get(SDL_GetBasePath());
//        Path expectedBasePath = Paths.get(System.getProperty("java.home"), "bin");
//        assertEquals(expectedBasePath, actualBasePath);
//        System.out.println(actualBasePath);
//    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
