package com.cleverlife.generator;


import com.cleverlife.generator.service.PearsonCriterionCounter;
import com.cleverlife.generator.service.RandomNumbersGenerator;
import com.cleverlife.generator.service.impl.LemaireGenerator;
import com.cleverlife.generator.service.impl.PearsonCriterionCounterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PiersonCriterionLemaireTest {

    RandomNumbersGenerator lemaireGenerator;
    PearsonCriterionCounter pearsonCriterionCounter;

    @BeforeEach
    void setUp() {
        lemaireGenerator = new LemaireGenerator(12);
        pearsonCriterionCounter = new PearsonCriterionCounterImpl();
    }

    @Test
    void testLemaireGeneratorViaPearsonCriterionFor20Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            pseudoRandomSequence.add(lemaireGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 20);
        System.out.println("Experimental Pearson criterion for 20 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 30.1435;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }


    @Test
    void testLemaireGeneratorViaPearsonCriterionFor40Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 1600; i++) {
            pseudoRandomSequence.add(lemaireGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 40);
        System.out.println("Experimental Pearson criterion for 40 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 54.5722;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }

    @Test
    void testLemaireGeneratorViaPearsonCriterionFor60Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 3600; i++) {
            pseudoRandomSequence.add(lemaireGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 60);
        System.out.println("Experimental Pearson criterion for 60 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 77.9305;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }

    @Test
    void testLemaireGeneratorViaPearsonCriterionFor70Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 3600; i++) {
            pseudoRandomSequence.add(lemaireGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 70);
        System.out.println("Experimental Pearson criterion for 70 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 90.531;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }

    @Test
    void testLemaireGeneratorViaPearsonCriterionFor100Intervals() {
        List<Integer> pseudoRandomSequence = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            pseudoRandomSequence.add(lemaireGenerator.nextInt());
        }
        double experimentalPearsonCriterion =
                pearsonCriterionCounter.countExperimentalPearsonCriterionForPseudoRandomSequence(pseudoRandomSequence, 100);
        System.out.println("Experimental Pearson criterion for 100 intervals is " + experimentalPearsonCriterion);
        double criticalPearsonCriterion = 129.9958;
        Assertions.assertTrue(experimentalPearsonCriterion < criticalPearsonCriterion);
    }
}
