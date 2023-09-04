package paren.sop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

class AppTest {
    @Test void popCanReceiveAStackAndACharacterAsParameters() {
        App app = new App();
        Stack p = new Stack();
        app.pop(p, ')');
    }

    @Test void topCanReceiveAStackAsParameter() {
        App app = new App();
        Stack p = new Stack();
        p.push('[');
        app.top(p);
    }

    @Test void topReturnsTheLastPushedCharacter() {
        App app = new App();
        Stack p = new Stack();
        app.pop(p, '}');
        assertEquals('}', app.top(p));
    }

    @Test void evaluateExpressionReturnsFalseIfFirstCharacterIsASingleClosingParenthesis() {
        App app = new App();
        Stack p = new Stack();
        char[] invalid_expression = ")".toCharArray();
        assertFalse(app.evaluateExpression(p, invalid_expression));
    }

    @Test void evaluateExpressionReturnsFalseIfFirstCharacterIsASingleOpeningParenthesis() {
        App app = new App();
        Stack p = new Stack();
        char[] invalid_expression = "(".toCharArray();
        assertFalse(app.evaluateExpression(p, invalid_expression));
    }

    @Test void evaluateExpressionReturnsFalseForInvalidTinyExpression() {
        App app = new App();
        Stack p = new Stack();
        char[] invalid_expression = "(()".toCharArray();
        assertFalse(app.evaluateExpression(p, invalid_expression));
    }

    @Test void evaluateExpressionReturnsFalseForInvalidLongExpression() {
        App app = new App();
        Stack p = new Stack();
        char[] invalid_expression = "((((((((())))))))".toCharArray();
        assertFalse(app.evaluateExpression(p, invalid_expression));
    }

    @Test void evaluateExpressionReturnsTrueForValidTinyExpression() {
        App app = new App();
        Stack p = new Stack();
        char[] valid_expression = "()".toCharArray();
        assertTrue(app.evaluateExpression(p, valid_expression));
    }

    @Test void evaluateExpressionReturnsTrueForValidLongExpression() {
        App app = new App();
        Stack p = new Stack();
        char[] valid_expression = "((((((((((()))))))))))".toCharArray();
        assertTrue(app.evaluateExpression(p, valid_expression));
    }
}
