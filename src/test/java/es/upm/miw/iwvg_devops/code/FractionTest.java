package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    private List<Fraction> fractions;

    @BeforeEach
    void setUp() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        fractions.add(new Fraction(4, 8));
    }

    @Test
    void setNumeratorTest() {
        int[] numerators = {1, 3, 4};
        for (int i = 0; i < fractions.size(); i++) {
            fractions.get(i).setNumerator(numerators[i]);
        }

        for (int i = 0; i < fractions.size(); i++) {
            assertEquals(numerators[i], fractions.get(i).getNumerator());
        }
    }

    @Test
    void setDenominatorTest() {
        int[] denominators = {6, 8, 9};
        for (int i = 0; i < fractions.size(); i++) {
            fractions.get(i).setDenominator(denominators[i]);
        }

        for (int i = 0; i < fractions.size(); i++) {
            assertEquals(denominators[i], fractions.get(i).getDenominator());
        }
    }

    @Test
    void decimalTest() {
        double[] expectedDecimals = {0.5, 0.75, 0.5};
        for (int i = 0; i < fractions.size(); i++) {
            assertEquals(expectedDecimals[i], fractions.get(i).decimal(), 0.0001);
        }
    }
}
