package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    /**elems is a DLinkList which is used to implement Queue's operations*/
    private DLinkList<E> elems = new DLinkList<>() ;

    /**enqueue method add an object (the object passed to the method) to the end of the Queue*/
    @Override
    public void enqueue(E x) {
        /**Test if the Queue is empty or if it is not equal to null
         * if it is True then we had add the element to the Queue.
         * */
        if(isEmpty() || elems != null)
            elems.addfirst(x);
        else{ /**If conditions are not fulfill this exception is thrown */
            throw new IllegalStateException("The queue is full");
        }
    }

    /**dequeue method removes the object at the beginning of the Queue*/
    @Override
    public E dequeue() {
        if(isEmpty()) /**If the Queue is empty then it's impossible to removes something -> throw exceptions*/
            throw new IllegalStateException("The queue is empty");
        else{
            elems.removeLast();
        }
        return null;
    }

    /**This method returns the size of the Queue*/
    @Override
    public int numOfElems() {
        return elems.listSize();
    }

    /**Retrieves the head of the Queue*/
    @Override
    public E peek() {
        if(isEmpty()) /**If the Queue is empty then it's impossible to retrieve the head -> throw exception*/
            throw new IllegalStateException("To be implemented");
        else{
           return  elems.peekTail();
        }
    }
    /**Return the size == 0 for the queue*/
    @Override
    public boolean isEmpty(){
        return elems.size == 0;
    }

    /**toString method of the Queue*/
    @Override
    public String toString(){
        return elems.toString();
    }
}
