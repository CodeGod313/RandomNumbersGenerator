package com.cleverlife.generator;

import com.cleverlife.generator.service.PearsonCriterionCounter;
import com.cleverlife.generator.service.RandomNumbersGenerator;
import com.cleverlife.generator.service.impl.MiddleMultiplicationGenerator;
import com.cleverlife.generator.service.impl.PearsonCriterionCounterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PearsonCriterionMiddleMultiplicationTest {
    RandomNumbersGenerator middleMultiplicationGenerator;
    PearsonCriterionCounter pearsonCriterionCounter;

    @BeforeEach
    void setUp() {
        middleMultiplicationGenerator = new MiddleMultiplicationGenerator(12);
        pearsonCriterionCounter = new PearsonCriterionCounterImpl();
    }

    @Test
    void testMiddleMultiplicationViaPearsonCriterionFor20Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 40000; i++) {
            pseudoRandomSequence.add(middleMultiplicationGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 20);
        System.out.println("Experimental Pearson criterion for 20 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 30.1435;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }


    @Test
    void testMiddleMultiplicationViaPearsonCriterionFor40Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 160000; i++) {
            pseudoRandomSequence.add(middleMultiplicationGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 40);
        System.out.println("Experimental Pearson criterion for 40 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 54.5722;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }

    @Test
    void testMiddleMultiplicationViaPearsonCriterionFor60Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 360000; i++) {
            pseudoRandomSequence.add(middleMultiplicationGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 60);
        System.out.println("Experimental Pearson criterion for 60 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 77.9305;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }
    @Test
    void testMiddleMultiplicationViaPearsonCriterionFor70Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 360000; i++) {
            pseudoRandomSequence.add(middleMultiplicationGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 70);
        System.out.println("Experimental Pearson criterion for 70 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 90.531;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }

    @Test
    void testMiddleMultiplicationViaPearsonCriterionFor100Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            pseudoRandomSequence.add(middleMultiplicationGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 100);
        System.out.println("Experimental Pearson criterion for 100 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 129.9958;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }
}
