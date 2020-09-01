package com.company;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.ListIterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int size = 0;


    public class Node{
        private Item item;
        private Node next;
        private Node prev;

    }
    // construct an empty deque  ?why empty lol

    public Deque(){

    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }
    private void validateNode(Item item){
        if (item == null){
            throw new NullPointerException("Null pointer to method addFirst and addLast are invalid");
        }
    }
    private void listvalidate (){
        if (size == 0){
            throw new java.util.NoSuchElementException("Empty queue you are removing from");
        }
    }
    // add the item to the front
    public void addFirst(Item item){
        validateNode(item);
        Node node_old = first;
        first = new Node();
        first.item = item;
        first.next = node_old;
        first.prev = null;
        if (isEmpty()){
            last = first;
        }
        else{
            node_old.prev = first;
        }
        size ++;


    }

    // add the item to the back
    public void addLast(Item item){
        validateNode(item);
        Node node_old = last;
        last = new Node();
        last.item = item;
        last.next= null;
        last.prev = node_old;
        if (isEmpty()){
            first = last;
        } else{
            node_old.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        listvalidate();
        size --;

        Item item = first.item;
        if (isEmpty()){
            first = null;
            last = null;
        }

        else{
            first = first.next;
            first.prev = null;
        }


        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        listvalidate();
        size --;
        Item item = last.item;

        if (isEmpty()){
            first =null;
            last =null;
        }else{
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new ListIterator() ;
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            else{
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("can't remove item from an iterator ");
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        System.out.println("hello");
        Deque<String> deque = new Deque<>();

        while (!StdIn.isEmpty()){

//            System.out.println("what");
            String s = StdIn.readString();
//            System.out.println(s);
            if (s.equals("-")){
                StdOut.print(deque.removeLast());
            }else{
                deque.addFirst(s);
            }
//            System.out.println("ok2");

        }

    }

}