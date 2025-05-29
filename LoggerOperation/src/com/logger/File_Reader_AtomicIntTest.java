package com.logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class File_Reader_AtomicIntTest {

    File_Reader_AtomicInt fileReaderAtomicInt = new File_Reader_AtomicInt();


    String File_Path = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\LoggerOperation\\logtest";


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void readData1() throws InterruptedException {
        fileReaderAtomicInt.readData1(File_Path);
    }

    @Test
    void getLog_Counts() {
    }
}