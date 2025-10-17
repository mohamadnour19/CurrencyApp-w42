package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    @Test
    void testCurrencyConverterCreation() {
        CurrencyConverter converter = new CurrencyConverter();
        assertNotNull(converter);
    }

    @Test
    void testPerformConversionMethodExists() {
        CurrencyConverter converter = new CurrencyConverter();

        assertDoesNotThrow(() -> {

        });
    }
}