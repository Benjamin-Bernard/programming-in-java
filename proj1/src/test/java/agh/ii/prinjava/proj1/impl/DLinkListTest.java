package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        dLinkList.addfirst(1);
        dLinkList.addfirst(2);
        dLinkList.addfirst(3);
        dLinkList.addfirst(4);
        dLinkList.addfirst(5);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addfirst() {
      dLinkList.addfirst(6);
      assertEquals(6,dLinkList.peekHead());
      assertEquals(6,dLinkList.listSize());
    }

    @Test
    void addlast() {
        dLinkList.addlast(7);
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
        assertEquals(2, dLinkList.peekTail());
    }

    @Test
    void listSize() {
        assertEquals(5,dLinkList.listSize());
    }

}