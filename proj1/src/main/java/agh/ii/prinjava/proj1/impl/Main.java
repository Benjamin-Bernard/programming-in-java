package agh.ii.prinjava.proj1.impl;

public class Main {
    public static void main(String[] args){
        DLinkList d = new DLinkList();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        d.addFirst(5);
        d.addFirst(2);
        d.addFirst(15);
        System.out.println(d);
        d.removeFirst();
        d.removeLast();
        System.out.println(d);
        System.out.println(d.peekHead());

        System.out.println("######################  Queue #################");
        MyQueueDLLBImpl queue = new MyQueueDLLBImpl<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue);
        System.out.println(queue.numOfElems());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue);
        System.out.println(queue.numOfElems());
        System.out.println(queue.peek());

        System.out.println("######################  Stack #################");

        MyStackDLLBImpl stack = new MyStackDLLBImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());

    }



}
