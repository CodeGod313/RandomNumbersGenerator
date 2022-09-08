package com.cleverlife.generator.service.impl;

import com.cleverlife.generator.service.RandomNumbersGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LemaireGeneratorTest {

    RandomNumbersGenerator generator;

    @BeforeAll
    void setUp(){
        generator = new LemaireGenerator(12);
    }

    @Test
    void nextInt() {
        for(int i = 0; i<100; i++){
            System.out.println(generator.nextInt() % 10);
        }
    }
}