package com.cleverlife.generator.service.impl;

import com.cleverlife.generator.service.RandomNumbersGenerator;

public class MiddleMultiplicationGenerator implements RandomNumbersGenerator {
    private static final int R0 = 1995959;
    private int seed;
    private int r2;

    public MiddleMultiplicationGenerator(int seed) {
        this.seed = seed;
        long multiplication = (long) seed * R0;
        r2 = (int) (multiplication % Integer.MAX_VALUE);
    }
    @Override
    public int nextInt() {
        String r2String = Integer.toString(r2);
        int numberLength = r2String.length();
        int randomNumberLength = numberLength - 2;
        int borderLength = 1;
        StringBuilder randomNumberBuilder = new StringBuilder();
        for (int i = borderLength; i < borderLength + randomNumberLength; i++) {
            randomNumberBuilder.append(r2String.charAt(i));
        }
        int randomNumber = Integer.parseInt(randomNumberBuilder.toString());
        int r1 = seed;
        seed = randomNumber;
        long multiplication = (long) r1 * seed;
        r2 = (int) (multiplication % Integer.MAX_VALUE);
        return randomNumber;
    }
}
