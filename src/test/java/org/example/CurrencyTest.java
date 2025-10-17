package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void testConvertSEKToUSD() {

        double result = Currency.SEK.convertTo(Currency.USD, 100.0);
        assertEquals(9.20, result, 0.01);
    }

    @Test
    void testConvertUSDToSEK() {

        double result = Currency.USD.convertTo(Currency.SEK, 10.0);
        assertEquals(108.70, result, 0.01);
    }

    @Test
    void testConvertSEKToEUR() {

        double result = Currency.SEK.convertTo(Currency.EUR, 100.0);
        assertEquals(8.50, result, 0.01);
    }

    @Test
    void testSameCurrencyConversion() {

        double result = Currency.SEK.convertTo(Currency.SEK, 100.0);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testFormatCurrency() {
        assertEquals("100.00 kr", Currency.SEK.format(100.0));
        assertEquals("50.50 $", Currency.USD.format(50.5));
        assertEquals("25.25 €", Currency.EUR.format(25.25));
    }
}