package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByUserName() {
        Stream<Double> antonioFractions = new Searches().findDecimalFractionByUserName("Paula");
        assertEquals(List.of(1.0,1.0, Double.NaN, Double.POSITIVE_INFINITY , 1.0),antonioFractions.toList());
    }

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        // Fraction "López" -> "L."
        Fraction fractionProper =   new Fraction(1, 5);
        Stream<String> familyNameInitial = new Searches().findUserFamilyNameInitialBySomeProperFraction(fractionProper);
        assertEquals(List.of("L."), familyNameInitial.toList());
    }

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        Fraction fractionImproper =   new Fraction(4, 3);
        Stream<String> familyNameInitial = new Searches().findUserFamilyNameBySomeImproperFraction(fractionImproper);
        assertEquals(List.of("Blanco"), familyNameInitial.toList());
    }

    @Test
    void testFindFractionAdditionByUserId() {
        Fraction fractionAdd =   new Fraction(16, 8);
        Optional<Fraction> fractionAdditionByUserId = new Searches().findFractionAdditionByUserId("4");
        assertTrue(fractionAdditionByUserId.isPresent());
        assertEquals(fractionAdd, fractionAdditionByUserId.get());
    }

}