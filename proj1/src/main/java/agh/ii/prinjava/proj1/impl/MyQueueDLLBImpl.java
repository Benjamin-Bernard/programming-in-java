package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems;
    private int size;

    public MyQueueDLLBImpl(int size) {
        this.elems = new DLinkList<>();
        this.size = size;
    }

    @Override
    public void enqueue(E x) {
        if(isEmpty() || numOfElems()< size  || elems != null){
            elems.addfirst(x);
        }
        else{
            throw new IllegalStateException("The queue is full");
        }

    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalStateException("The queue is empty");
        else{
            elems.removeFirst();
        }
        return null;
    }

    @Override
    public int numOfElems() {
        return elems.size;
    }

    @Override
    public E peek() {
        if(isEmpty())
            throw new IllegalStateException("To be implemented");
        else{
            ;
        }
        return null;

    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }
}
