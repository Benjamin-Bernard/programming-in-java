package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        dLinkList.addFirst(3);
        dLinkList.addFirst(4);
        dLinkList.addFirst(5);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addfirst() {
      dLinkList.addFirst(6);
      assertEquals(6,dLinkList.peekHead());
      assertEquals(6,dLinkList.listSize());
    }

    @Test
    void addlast() {
        dLinkList.addLast(7);
        assertEquals(7,dLinkList.peekTail());
        assertEquals(6,dLinkList.listSize());
    }

    @Test
    void removeFirst() {
        dLinkList.removeFirst();
        assertEquals(4,dLinkList.peekHead());
        assertEquals(4,dLinkList.listSize());
    }

    @Test
    void removeLast() {
        dLinkList.removeLast();
        assertEquals(2,dLinkList.peekTail());
        assertEquals(4,dLinkList.listSize());
    }

    @Test
    void peekHead() {
        assertEquals(5, dLinkList.peekHead());
    }

    @Test
    void peekTail() {
        assertEquals(1, dLinkList.peekTail());
    }

    @Test
    void listSize() {
        assertEquals(5,dLinkList.listSize());
    }

}