package org.libsdl.api.rwops;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.SdlTest;
import org.libsdl.jna.size_t;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.libsdl.api.SDL_SubSystem.SDL_INIT_VIDEO;
import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.rwops.SdlRWops.SDL_LoadFile;
import static org.libsdl.api.rwops.SdlRWops.SDL_LoadFile_RW;
import static org.libsdl.api.rwops.SdlRWops.SDL_RWFromFile;
import static org.libsdl.api.rwops.SdlRWops.SDL_RWclose;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_Free;

public final class SdlRWopsTest {

    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    @Test
    public void rwOpsShouldLoadFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");
        Memory buffer = new Memory(1024L);

        SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
        assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        try {
            SDL_RWReadFunction readFunction = ops.read;
            size_t actualReadCount = readFunction.read(ops, buffer, new size_t(1L), new size_t(buffer.size()));

            assertEquals(Files.size(sampleFile), actualReadCount.longValue());
            long offset = 0L;
            assertEquals('T', (char) (buffer.getByte(offset++)));
            assertEquals('h', (char) (buffer.getByte(offset++)));
            assertEquals('i', (char) (buffer.getByte(offset++)));
            assertEquals('s', (char) (buffer.getByte(offset++)));
            assertEquals(' ', (char) (buffer.getByte(offset++)));
            assertEquals('i', (char) (buffer.getByte(offset++)));
            assertEquals('s', (char) (buffer.getByte(offset)));
        } finally {
            SDL_RWclose(ops);
        }
    }

    @Test
    public void rwOpsShouldReportCorrectFileSize() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");

        SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
        assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        try {
            SDL_RWSizeFunction readFunction = ops.size;
            long actualFileSize = readFunction.size(ops);

            assertEquals(Files.size(sampleFile), actualFileSize);
        } finally {
            SDL_RWclose(ops);
        }
    }

    @Test
    public void LoadFileUsingRwOpsShouldGiveFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");

        SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
        assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        size_t.Ref actualReadCount = new size_t.Ref();
        Pointer buffer = SDL_LoadFile_RW(ops, actualReadCount, 1);

        assertEquals(Files.size(sampleFile), actualReadCount.getValue().longValue());
        long offset = 0L;
        assertEquals('T', (char) (buffer.getByte(offset++)));
        assertEquals('h', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset++)));
        assertEquals(' ', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset)));
    }

    @Test
    public void LoadFileShouldGiveFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");
        int allocCount = SDL_GetNumAllocations();

        size_t.Ref actualReadCount = new size_t.Ref();
        Pointer buffer = SDL_LoadFile(sampleFile.toString(), actualReadCount);
        assertNotNull(buffer, "Failed to load file " + sampleFile + ": " + SDL_GetError());

        assertEquals(Files.size(sampleFile), actualReadCount.getValue().longValue());
        long offset = 0L;
        assertEquals('T', (char) (buffer.getByte(offset++)));
        assertEquals('h', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset++)));
        assertEquals(' ', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset)));

        assertEquals(allocCount+1, SDL_GetNumAllocations());
        SDL_Free(buffer);
        assertEquals(allocCount, SDL_GetNumAllocations());
    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
