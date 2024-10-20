package com.learn.leetcode.daily.q202410.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsingABooleanExpressionTest {

    @Test
    void parseBoolExpr1() {
        final var expression = "&(|(f))";
        final var expected = false;
        final var result = ParsingABooleanExpression.parseBoolExpr(expression);

        assertEquals(expected, result);
    }

    @Test
    void parseBoolExpr2() {
        final var expression = "|(f,f,f,t)";
        final var expected = true;
        final var result = ParsingABooleanExpression.parseBoolExpr(expression);

        assertEquals(expected, result);
    }


    @Test
    void parseBoolExpr3() {
        final var expression = "!(&(f,t))";
        final var expected = true;
        final var result = ParsingABooleanExpression.parseBoolExpr(expression);

        assertEquals(expected, result);
    }

    @Test
    void parseBoolExpr4() {
        final var expression = "&(!(&(!(&(!(t),&(f),|(f))),!(&(t)),|(f))),!(!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t)," +
                "|(f,f,t))))),&(!(!(&(&(!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t)))," +
                "&(&(!(&(f)),&(t),|(f,f,t)),|(t),|(f,f,t)),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))," +
                "&(&(&(!(&(f)),|(t),&(!(t),!(|(f,f,t)),!(&(f)))),!(|(f,f,t)),&(t,t,f)),&(f),&(&(t)," +
                "&(!(t),!(|(f,f,t)),!(&(f))),|(f,f,t))),&(&(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t)," +
                "|(f,f,t))),&(t,t,f),&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f)," +
                "|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))))),!(!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t)," +
                "|(f,f,t))),&(t)))),!(|(t)))))),&(&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f),&(!(t)," +
                "&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t)))),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t)))," +
                "&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))),&(&(&(&(&(f),&(!(t),&(f)," +
                "|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t,t,f),&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f)," +
                "&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))))),&(t,t,f),&(!(!(&(|(f,f,t),&(&(f),&(!(t),&(f)," +
                "|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t)))),&(!(&(f)),&(t),|(f,f,t)),&(&(&(!(&(f)),|(t),&(!(t),!(|(f,f,t))," +
                "!(&(f)))),!(|(f,f,t)),&(t,t,f)),&(f),&(&(t),&(!(t),!(|(f,f,t)),!(&(f))),|(f,f,t))))),!(&(&(!(&(f))," +
                "&(t),|(f,f,t)),&(t),&(t,t,f))),&(f))))";
        final var expected = false;
        final var result = ParsingABooleanExpression.parseBoolExpr(expression);

        assertEquals(expected, result);
    }

    @Test
    void parseBoolExpr5() {
        final var expression = "!(&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f)))";
        final var expected = true;
        final var result = ParsingABooleanExpression.parseBoolExpr(expression);

        assertEquals(expected, result);
    }

    @Test
    void parseBoolExpr6() {
        final var expression = "|(&(t,f,t,!(&(|(f,f,f,f)))),t)";
        final var expected = true;
        final var result = ParsingABooleanExpression.parseBoolExpr(expression);

        assertEquals(expected, result);
    }
}