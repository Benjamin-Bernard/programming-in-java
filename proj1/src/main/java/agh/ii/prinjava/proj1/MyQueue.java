package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;


/** All these methods are here in order to be initialized.
 * We will use them later
 */

public interface MyQueue<E> {
    /** This is the method to add an element to the queue*/
    void enqueue(E x);
    /** This is the method to erase an element from the queue*/
    E dequeue();


    /**
     * This is the method that lets us know if a list is empty or not :
     * True means the list is empty
     * False means the list contains elements
     * */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }
    /** This method returns the list size */
    int numOfElems();

    E peek(); /** This method returns the last element put in the stack */

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
