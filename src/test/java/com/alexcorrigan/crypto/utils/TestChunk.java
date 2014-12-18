package com.alexcorrigan.crypto.utils;

import com.alexcorrigan.crypto.utils.Chunker;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class TestChunk {

    private Chunker chunker;

    @Before
    public void setUp() throws Exception {
        chunker = new Chunker();
    }

    @Test
    public void defaultChunks() throws Exception {
        assertEquals("", chunker.chunk(""));
        assertEquals("a", chunker.chunk("a"));
        assertEquals("aaaa", chunker.chunk("aaaa"));
        assertEquals("aaaa a", chunker.chunk("aaaaa"));
        assertEquals("aaaa aaaa", chunker.chunk("aaaaaaaa"));
    }

    @Test
    public void numberedChunkSizes() throws Exception {
        assertEquals("a a a a a a a a", chunker.chunk(1, "aaaaaaaa"));
        assertEquals("aa aa aa aa", chunker.chunk(2, "aaaaaaaa"));
        assertEquals("aaa aaa aa", chunker.chunk(3, "aaaaaaaa"));
        assertEquals("aaaaaaaa", chunker.chunk(8, "aaaaaaaa"));
        assertEquals("aaaaaaaa", chunker.chunk(100, "aaaaaaaa"));
    }

    @Test
    public void chunkSizeMustBeGreaterThanZero() throws Exception {
        Exception caughtException = null;
        try {
            chunker.chunk(0, "aaa");
        } catch (Exception e) {
            caughtException = e;
        }
        assertNotNull(caughtException);
        Assert.assertEquals("Chunk size must be greater than zero", caughtException.getMessage());
    }

    @Test
    public void ignoresWhiteSpace() throws Exception {
        assertEquals("aaaa", chunker.chunk(" aa aa "));
    }
}
