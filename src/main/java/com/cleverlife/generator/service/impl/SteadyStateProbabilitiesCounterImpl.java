package com.cleverlife.generator.service.impl;

import com.cleverlife.generator.service.RandomNumbersGenerator;
import com.cleverlife.generator.service.SteadyStateProbabilitiesCounter;

import java.util.*;

public class SteadyStateProbabilitiesCounterImpl implements SteadyStateProbabilitiesCounter {

    private final RandomNumbersGenerator randomGenerator;

    public SteadyStateProbabilitiesCounterImpl(RandomNumbersGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public List<Double> countSteadyStateProbabilities(double[][] matrix, int startState, double d) {
        int n = matrix.length;
        int numberOfCounts = 0;
        List<Integer> countOfStates = new ArrayList<>();
        double precision = 99999999;
        int currentState = startState;
        List<Double> previousProbabilities = new ArrayList<>(0);

        for (int i = 0; i < n; i++) {
            previousProbabilities.add(0.);
            countOfStates.add(0);
        }

        double[][] probabilitiesMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            probabilitiesMatrix[i][0] = matrix[i][0];
        }


        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                probabilitiesMatrix[i][j] = probabilitiesMatrix[i][j - 1] + matrix[i][j];
            }
        }


        while (numberOfCounts < 100 || precision > d) {

            double randomNumber = randomGenerator.nextInt() % 100;
            randomNumber /= 100;

            for (int i = 0; i < n; i++) {
                if (probabilitiesMatrix[currentState][i] >= randomNumber) {
                    int currentStateCount = countOfStates.get(i);
                    countOfStates.set(i, currentStateCount + 1);
                    currentState = i;
                    break;
                }
            }

            numberOfCounts++;
            precision = Math.abs(previousProbabilities.get(0) - (double) countOfStates.get(0) / numberOfCounts);
            for (int i = 1; i < n; i++) {
                double currentPrecision = (double) countOfStates.get(i) / numberOfCounts - previousProbabilities.get(i);
                if (currentPrecision > precision) {
                    precision = currentPrecision;
                }
            }
            for (int i = 0; i < n; i++) {
                double currentProbability = (double) countOfStates.get(i) / numberOfCounts;
                previousProbabilities.set(i, currentProbability);
            }
        }
        final int numberOfCountsEffective = numberOfCounts;
        List<Double> resultProbabilities = countOfStates
                .stream()
                .map(x -> (double) x / numberOfCountsEffective)
                .toList();
        return resultProbabilities;
    }
}
