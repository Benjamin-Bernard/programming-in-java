package agh.ii.prinjava.proj1.impl;


import java.util.LinkedList;

public class DLinkList<E> {
    // ...

    Node head;
    Node tail;
    int size;

    //Empty DLinkList
    public DLinkList DLinkListNew(){
       DLinkList pnew = new DLinkList();
       if(pnew != null){
           pnew.size = 0;
           pnew.head = null;
           pnew.tail = null;
       }
       return pnew;

    }


    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        public Node(T elem ){
            this.elem = elem;
            this.prev = null;
            this.next = null;
        }

        public Node(){
            this(null);
        }

    }

    public void addfirst(E e){
        Node newNode = new Node(e);
        if(head != null){
            newNode.prev = null;
            newNode.next = head;
            head = newNode;
        }
        else{
            head = tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        }

        size++;

    }

    public void addlast(E e){
        Node newNode = new Node(e);
        if(head != null){
            newNode.prev = tail;
            tail.next = newNode;
            newNode.next = null;
            tail = newNode;
        }
        else{
            head = tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        }
        size ++;
    }

    public void removeFirst(){
        Node temp;
        if(head != null){

            temp = head;
            head = temp.next;
            if(temp.next != null){
                head.prev = null;

            }
            size --;
        }

    }

    public  void removeLast(){
        Node temp;
        if(head != null){

            temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            if(temp.prev != null)
                temp.prev.next = null;
            else
                head = null;
            size --;
        }

    }

  /*  public void delete(DLinkList dl){
        if(dl != null){
            Node temp = new Node<>();
            temp = dl.head;

            while(temp != null){
                Node del = new Node<>();
                del = temp;
                temp = del.
            }

        }
    }*/

    public int listSize(){
            return size;
    }
/*
    public void printNodes() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Print each node and then go to next.
            System.out.print(current.elem + " ");
            current = current.next;
        }
        //System.out.println("\n" + head.elem + "\n" + tail.elem);
    }*/

    @Override
    public String toString(){
        String s = "";
        //Node current will point to head
        Node current = head;
        if(head == null) {
            return "Doubly linked list is empty";
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Print each node and then go to next.
            s+= current.elem + " ";
            current = current.next;
        }
        return s;
    }

}
