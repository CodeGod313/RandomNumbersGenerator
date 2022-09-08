package com.cleverlife.generator.service;

import java.util.List;

public interface PearsonCriterionCounter {
    double countExperimentalPearsonCriterionForPseudoRandomSequence(List<Integer> pseudoRandomSequence, int intervalsNumber);
}
