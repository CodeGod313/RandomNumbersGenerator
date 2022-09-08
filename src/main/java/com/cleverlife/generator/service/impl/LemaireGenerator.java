package com.cleverlife.generator.service.impl;

import com.cleverlife.generator.service.RandomNumbersGenerator;

public class LemaireGenerator implements RandomNumbersGenerator {

    private static final int A = 11623;
    private int seed;

    public LemaireGenerator(int seed) {
        this.seed = seed;
    }

    @Override
    public int nextInt() {
        long multiplication = (long) A * seed;
        seed = (int) (multiplication % Integer.MAX_VALUE);
        return seed;
    }
}
