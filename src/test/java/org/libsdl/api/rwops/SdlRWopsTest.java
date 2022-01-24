package org.libsdl.api.rwops;

import java.nio.file.Files;
import java.nio.file.Path;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.SdlTest;
import org.libsdl.jna.SizeT;

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
import static org.libsdl.api.stdinc.SdlStdinc.SDL_Free;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;

public final class SdlRWopsTest {

    String sampleFileName = "sample.txt";

    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    private SDL_RWops rwOpsOpenFile(Path sampleFile) {
        SDL_RWops ops = SDL_RWFromFile(sampleFile.toString(), "rb");
        assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        return ops;
    }

    @Test
    @SuppressWarnings("checkstyle:MagicNumber")
    public void rwOpsShouldLoadFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, this.sampleFileName);
        Memory buffer = new Memory(1024L);

        SDL_RWops ops = this.rwOpsOpenFile(sampleFile);
        try {
            SDL_RWReadFunction readFunction = ops.read;
            SizeT actualReadCount = readFunction.read(ops, buffer, new SizeT(1L), new SizeT(buffer.size()));

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
        Path sampleFile = SdlTest.getSampleFile(this, this.sampleFileName);

        SDL_RWops ops = this.rwOpsOpenFile(sampleFile);
        try {
            SDL_RWSizeFunction readFunction = ops.size;
            long actualFileSize = readFunction.size(ops);

            assertEquals(Files.size(sampleFile), actualFileSize);
        } finally {
            SDL_RWclose(ops);
        }
    }

    @Test
    public void loadFileUsingRwOpsShouldGiveFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, this.sampleFileName);

        SDL_RWops ops = this.rwOpsOpenFile(sampleFile);
        SizeT.Ref actualReadCount = new SizeT.Ref();
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
    public void loadFileShouldGiveFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, this.sampleFileName);
        int allocCount = SDL_GetNumAllocations();

        SizeT.Ref actualReadCount = new SizeT.Ref();
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

        assertEquals(allocCount + 1, SDL_GetNumAllocations());
        SDL_Free(buffer);
        assertEquals(allocCount, SDL_GetNumAllocations());
    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
