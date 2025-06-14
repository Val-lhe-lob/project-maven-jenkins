import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;



    @BeforeEach
    public void initCalculator() {
        System.out.println("Appel avant chaque test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefCalculator() {
        System.out.println("Appel après chaque test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tous les tests");
        final Instant endedAt = Instant.now();
        final long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @Test
    public void testAddTwoPositiveNumbers() {
        // Arrange
        final int a = 2;
        final int b = 3;

        // Act
        final int somme = calculatorUnderTest.add(a, b);

        // Assert
        assertThat(somme).isEqualTo(5);
        assertEquals(5, somme);
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
        // Arrange
        final int a = 42;
        final int b = 12;

        // Act
        final int produit = calculatorUnderTest.multiply(a, b);

        // Assert
        assertEquals(462, produit);
    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = { 1, 2, 42, 1011, 5089 })
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // Arrange -- Tout est prêt !

        // Act -- Multiplier par zéro
        final int actualResult = calculatorUnderTest.multiply(arg, 0);

        // Assert -- ça vaut toujours zéro !
        assertEquals(0, actualResult);
    }

    @ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
        // Arrange -- Tout est prêt !

        // Act
        final int actualResult = calculatorUnderTest.add(arg1, arg2);

        // Assert
        assertEquals(expectResult, actualResult);
    }

}
