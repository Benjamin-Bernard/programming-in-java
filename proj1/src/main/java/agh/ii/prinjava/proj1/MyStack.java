package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;


/**
 * All these methods are here in order to be initialized.
 * We will use them later
 */

public interface MyStack<E> {

    /**
     * This pop method erases the last element put in the stack
     */
    E pop();

    /**
     * This push method adds an element in the stack
     */
    void push(E x);

    /**
     * This is the method that lets us know if a list is empty or not :
     * True means the list is empty
     * False means the list contains elements
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }


    int numOfElems();

    /**
     * This method returns the list size
     */
    /** This method returns the last element put in the stack */
    E peek();

    /**
     * Consider pros and cons of having a factory method in the interface
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
