package com.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class File_Reader_AtomicIntTest {

    File_Reader_AtomicInt fileReaderAtomicInt;

    List<String> file = null;

   // String file= "logs";

    String File_Path = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\LoggerOperation\\logtest";


    @BeforeEach
    void setUp() {
        fileReaderAtomicInt = new File_Reader_AtomicInt();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testReadData1True() throws InterruptedException {
        assertDoesNotThrow(() -> fileReaderAtomicInt.readData1(File_Path));

    }

    @Test
    void testReadData1False(){
       LogProcessException exception= assertThrows(LogProcessException.class,()->fileReaderAtomicInt.readData1(""));
        assertEquals("No log file in Directory: ",exception.getMessage());
    }

    @Test
    void testgetLog_Counts() throws InterruptedException {
        fileReaderAtomicInt.readData1(File_Path);

        var counts= fileReaderAtomicInt.getLog_Counts();
        assertNotNull(counts);
        assertTrue(counts.containsKey("ERROR"));
        assertTrue(counts.containsKey("WARNING"));
        assertTrue(counts.containsKey("INFO"));


        System.out.println("ERROR COUNT: "+counts.get("ERROR").get());
        System.out.println("WARNING COUNT: "+counts.get("WARNING").get());
        System.out.println("INFO: "+counts.get("INFO").get());

        assertTrue(counts.get("ERROR").get() >= 0);
        assertTrue(counts.get("WARNING").get() >= 0);
        assertTrue(counts.get("INFO").get() >= 0);


    }
}