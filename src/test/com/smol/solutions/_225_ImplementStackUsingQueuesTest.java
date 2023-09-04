package com.smol.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _225_ImplementStackUsingQueuesTest {
    _225_ImplementStackUsingQueues obj = new _225_ImplementStackUsingQueues();

    @BeforeEach
    void setUp() {
        obj = new _225_ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
    }

    @Test
    void push() {
        assertEquals(2, obj.pop());
        assertEquals(1, obj.pop());
    }

    @Test
    void top() {
        assertEquals(2, obj.top());
        assertEquals(2, obj.top());
    }

    @Test
    void pop() {
        assertEquals(2, obj.pop());
        assertEquals(1, obj.pop());
    }


    @Test
    void empty() {
        assertFalse(obj.empty());
        while (!obj.empty()) {
            obj.pop();
        }
        assertTrue(obj.empty());
    }
}