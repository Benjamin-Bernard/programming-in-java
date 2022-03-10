package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems;

    public MyStackDLLBImpl() {
        this.elems = new DLinkList<>();
    }

    @Override
    public E pop() {
        if(elems == null)
            throw new IllegalStateException("To be implemented");
        else{

        }
    }

    @Override
    public void push(E x) {
        throw new IllegalStateException("To be implemented");
    }

    @Override
    public int numOfElems() {
        throw new IllegalStateException("To be implemented");
    }

    @Override
    public E peek() {
        throw new IllegalStateException("To be implemented");
    }
}
