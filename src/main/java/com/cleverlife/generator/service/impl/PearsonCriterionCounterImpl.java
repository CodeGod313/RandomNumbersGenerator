package com.cleverlife.generator.service.impl;

import com.cleverlife.generator.service.PearsonCriterionCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PearsonCriterionCounterImpl implements PearsonCriterionCounter {
    @Override
    public double countExperimentalPearsonCriterionForPseudoRandomSequence(List<Integer> pseudoRandomSequence, int intervalsNumber) {
        int[] intervals = new int[intervalsNumber];
        pseudoRandomSequence.forEach(x -> intervals[x % intervalsNumber]++);
        int sum = Arrays.stream(intervals).sum();
        int uniformDistributionForEachPoint = sum / intervalsNumber;
        List<Double> distribution = new ArrayList<>();
        Arrays.stream(intervals).forEach(x -> {
            int difference = uniformDistributionForEachPoint - x;
            long multiplication = (long) difference * difference;
            double result = (double) multiplication / uniformDistributionForEachPoint;
            distribution.add(result);
        });
        double experimentalPearsonCriterion = distribution.stream().reduce(Double::sum).get();
        return experimentalPearsonCriterion;
    }
}
