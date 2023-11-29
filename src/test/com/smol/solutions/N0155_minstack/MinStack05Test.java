package com.smol.solutions.N0155_minstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinStack05Test {

    private MinStackInterface obj;
    private  String objName ;

    @BeforeEach
    void setUp() {
        obj = new MinStack05();
        objName = obj.getClass().getSimpleName();
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