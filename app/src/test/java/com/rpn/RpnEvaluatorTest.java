package com.rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RpnEvaluatorTest {

    private final RpnEvaluator evaluator = new RpnEvaluator();

    // ---------- Valid expressions ----------

    @Test
    void evaluateSimpleExpression() {
        assertEquals(14, evaluator.evaluate("3 4 + 2 *"));
    }

    @Test
    void evaluatesSubtractionOrderCorrectly() {
        assertEquals(2, evaluator.evaluate("5 3 -"));
    }

    // ---------- Invalid RPN structure ----------

    @Test
    void throwsWhenTooFewOperands() {
        assertThrows(IllegalArgumentException.class,
                () -> evaluator.evaluate("1 +"));
    }

    @Test
    void throwsWhenTooManyOperandsRemain() {
        assertThrows(IllegalArgumentException.class,
                () -> evaluator.evaluate("1 2 3 +"));
    }

    @Test
    void throwsOnEmptyExpression() {
        assertThrows(IllegalArgumentException.class,
                () -> evaluator.evaluate(""));
    }

    // ---------- Arithmetic errors ----------

    @Test
    void throwsOnDivisionByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> evaluator.evaluate("4 0 /"));
    }
}
