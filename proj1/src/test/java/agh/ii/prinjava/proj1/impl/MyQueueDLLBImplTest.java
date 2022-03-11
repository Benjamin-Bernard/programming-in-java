package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    @BeforeEach
    void setUp() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);
        queueOfInts.enqueue(4);
        queueOfInts.enqueue(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void enqueue() {
        queueOfInts.enqueue(6);
        assertEquals(1, queueOfInts.peek());
        assertEquals(6, queueOfInts.numOfElems());
    }

    @Test
    void dequeue() {
        queueOfInts.dequeue();
        assertEquals(2, queueOfInts.peek());
        assertEquals(4, queueOfInts.numOfElems());
    }

    @Test
    void numOfElems() {
        assertEquals(5, queueOfInts.numOfElems());
    }

    @Test
    void peek() {
        assertEquals(1, queueOfInts.peek());
    }

}