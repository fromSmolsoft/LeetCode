package com.smol.solutions.N0155_minstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinStack04Test {

    private MinStackInterface obj;

    @BeforeEach
    void setUp() {
        obj = new MinStack04();
    }

    @Test
    void test() {MinStackTestMethods.pushTopGetMin01(obj);}

    @Test
    void pushTopGetMin01() {MinStackTestMethods.pushTopGetMin01(obj);}

    @Test
    void pushTop() {MinStackTestMethods.pushTop(obj);}

    @Test
    void pushPop() {MinStackTestMethods.pushPop(obj);}

    @Test
    void pushGetMin() {MinStackTestMethods.pushGetMin(obj);}

    @Test
    void pushPopGetMin() {MinStackTestMethods.pushPopGetMin(obj);}
}