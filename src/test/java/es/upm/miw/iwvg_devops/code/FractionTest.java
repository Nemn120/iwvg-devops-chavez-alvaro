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

    @Test
    void isProperTest() {
        Fraction fraction1 = new Fraction(2, 5);
        assertTrue(fraction1.isProper());
    }

    @Test
    void isImproperTest() {
        Fraction fraction1 = new Fraction(12, 5);
        assertTrue(fraction1.isImproper());
    }

    @Test
    void isEquivalentTest() {
        Fraction fraction1 = new Fraction(6, 5);
        Fraction fraction2 = new Fraction(12, 10);

        assertTrue(fraction1.isEquivalent(fraction2));
        assertTrue(fraction2.isEquivalent(fraction1));
    }

    @Test
    void addTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction result = fraction1.add(fraction2);

        Fraction fraction = new Fraction(5, 4);
        assertTrue(fraction.isEquivalent(result));
    }

    @Test
    void multiplyTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);

        Fraction result = fraction1.multiply(fraction2);
        Fraction fraction = new Fraction(3, 8);

        assertTrue(fraction.isEquivalent(result));
    }

    @Test
    void divideTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);

        Fraction result = fraction2.divide(fraction1);

        assertEquals(new Fraction(6, 4).toString(), result.toString());
    }

    @Test
    void divideByZeroTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction zeroFraction = new Fraction(0, 1);

        assertThrows(IllegalArgumentException.class, () -> {
            fraction1.divide(zeroFraction);
        });
    }
}
