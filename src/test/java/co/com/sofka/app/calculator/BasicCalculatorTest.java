package co.com.sofka.app.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static junit.framework.Assert.assertEquals;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1 + 1 = 2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })

    public void severalSums(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several rests")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,      2,   -2",
            "10,     5,    5",
            "49,    40,    9",
            "100, -100,  200"
    })
    void severalRests(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.sub(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several mults")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,       9,      0",
            "5,       2,     10",
            "49,     35,   1715",
            "100,  -500, -50000"
    })
    void severalMults(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.mul(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divss")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,       5,    0",
            "10,      0,    0",
            "25,      5,    5",
            "100,  -200,   -0"
    })
    void severalDivs(Long first, Long second, Long expectedResult) {
        Assertions.assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }
}
