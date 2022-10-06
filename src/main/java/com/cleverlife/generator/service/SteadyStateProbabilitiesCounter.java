package com.cleverlife.generator.service;

import java.util.List;

public interface SteadyStateProbabilitiesCounter {
    List<Double> countSteadyStateProbabilities(double[][] matrix, int startState, double d);
}
