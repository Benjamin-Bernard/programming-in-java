package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/** <p>This class is where all method are concerning the stack </p> */

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems =  new DLinkList<>();


    /**
     * This pop method is here in order to erase the last element put in the stack
     * */
    @Override
    public E pop() {
        /**
         * First we are dealing with the case where the Stack is empty
         * */
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");

/**
 * Then, we are dealing the case where there is something to erase.
 * We call the removefirst method because we need to erase the last element put in the stack.
 */
        else{
            elems.removeFirst();
        }
        return null;
    }

    /** This push method is here in order to add an element in the stack */
    @Override
    public void push(E x) {
        /**
         * we are dealing the case where we can add an element in the stack
         * */
        if(elems != null)
            elems.addfirst(x);

        /**
         * we are dealing the case where there is an error.
         * */
        else{
            throw new IllegalStateException("To be implemented");
        }
    }


    /**
     * This is the method that return the list size
     * */
    @Override
    public int numOfElems() {
        return elems.listSize();
    }


    /**
     * This is the method that returns the last element put in the stack.
     * */

    @Override
    public E peek() {
        /**
         * Case where the stack is empty
         * */
        if(isEmpty())
            throw new IllegalStateException("To be implemented");

        /**
         * Case where the stack contains elements
         * */
        else{
            return  elems.peekHead();
        }
    }

    /**
     * This is the method that lets us know if a list is empty or not :
     * True means the list is empty
     * False means the list contains elements
     * */
    @Override
    public boolean isEmpty(){
        return elems.size == 0;
    }

    /**
     * It is thanks to this method that we can display the list in the console.
     * It enables to print things
     * */
    @Override
    public String toString(){
        return elems.toString();
    }
}
