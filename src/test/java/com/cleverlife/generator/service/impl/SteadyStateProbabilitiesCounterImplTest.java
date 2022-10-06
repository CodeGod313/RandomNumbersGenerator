package com.cleverlife.generator.service.impl;

import com.cleverlife.generator.service.RandomNumbersGenerator;
import com.cleverlife.generator.service.SteadyStateProbabilitiesCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SteadyStateProbabilitiesCounterImplTest {

    SteadyStateProbabilitiesCounter counter;
    RandomNumbersGenerator randomGenerator;
    double precision;
    double[][] matrix = {
            {0.4, 0.2, 0.4},
            {0.3, 0.1, 0.6},
            {0.2, 0.2, 0.6}};


    @BeforeAll
    void setUp(){
        randomGenerator = new LemaireGenerator(123);
        counter = new SteadyStateProbabilitiesCounterImpl(randomGenerator);
        precision = 0.01;
    }


    @Test
    void countSteadyStateProbabilities() {
        int startState = 0;
        List<Double> actual = counter.countSteadyStateProbabilities(matrix, startState, precision);
    }
}