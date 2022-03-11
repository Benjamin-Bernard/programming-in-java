package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    @BeforeEach
    void setUp() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        stackOfInts.push(4);
        stackOfInts.push(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void pop() {
        stackOfInts.pop();
        assertEquals(4, stackOfInts.peek());
        assertEquals(4, stackOfInts.numOfElems());
    }

    @Test
    void push() {
        stackOfInts.push(6);
        assertEquals(6, stackOfInts.peek());
        assertEquals(6, stackOfInts.numOfElems());
    }

    @Test
    void numOfElems() {
        assertEquals(5, stackOfInts.numOfElems());
    }

    @Test
    void peek() {
        assertEquals(5, stackOfInts.peek());
    }

}