package agh.ii.prinjava.proj1.impl;

/**
 <ul>
 * <li>We are working on this project with doubly linked list </li>
 * <li>A doubly linked list has an additional pointer known as the previous pointer </li>
 * <li>and has the next pointer as in the singly linked list.</li>
 *
 </ul>*/

public class DLinkList<E> {
    // ...
    /**Critical positions of the list :
     * head node
     * tail node
     * temp is a temporrary node ,we will use it in certain condition to travel all over the list
     * */

    /** Head will be used to indicated the first element of the list so it's kind
     * of a key that we shouldn't lose*/
    Node<E> head;
    /** tail will be used to indicated the last element of the list so it's kind of a key that we shouldn't lose*/
    Node<E> tail;
    Node<E> temp;
    /** Variable that indicate the size of the list*/
    int size;

    private static class Node<T> {
        /**Creation a Node of a Doubly liked list*/
        T elem;
        Node<T> next;
        Node<T> prev;

        public Node(T elem ){
            /**Constructor of a node */
            this.elem = elem;
            this.prev = null;
            this.next = null;
        }

    }
    /**Add an element at the head of the list */
    public void addfirst(E e){
        /**creation of a new node*/
        Node newNode = new Node(e);
        /**two cases:
         * Empty list
         * List with one or more element
         */

        /**List with one or more element*/

        if(head != null){
            newNode.prev = null;
            newNode.next = head;
            head = newNode;
        }
        /**Empty list*/
        else{
            head = tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        }
        /**update the new  size of the list t*/
        size++;
    }

    /**Add an element at the end of the list*/
    public void addlast(E e){
        /**Creation a Node of a Doubly liked list*/
        Node<E> newNode = new Node(e);
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

    /**Remove the first element from the list*/
    public void removeFirst(){
        if(head != null){
            temp = head;
            head = temp.next;
            if(temp.next != null){
                head.prev = null;
            }
            size --;
        }

    }

    /**Remove the last element from the list*/
    public  void removeLast(){
        if(head != null){
            temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size --;
        }

    }

    /**Return the head node of the list*/
    public E peekHead(){
        Node<E> n = head;
        return n.elem;
    }
    /**Return the tail node of the list*/
    public E peekTail(){
        Node<E> n = tail;
        return n.elem;
    }
    /**Return the size of the list*/
    public int listSize(){
            return size;
    }
    /**toSTring method of the list*/
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        Node current = head;
        if(head == null) {
            return "Doubly linked list is empty";
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Print each node and then go to next.
            s.append(current.elem).append(" ");
            current = current.next;
        }
        return s.toString();
    }

}
