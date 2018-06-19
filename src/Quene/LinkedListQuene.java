package Quene;

import Interface.Quene;

/**
 * Created by zeng.chengquan on 2018/5/29 0029.
 */
public class LinkedListQuene<E> implements Quene<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQuene() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public E dequene() {
        if(isEmpty()){
            throw new IllegalArgumentException("quene is empty");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head==null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public void enquene(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        sb.append("Quene.LinkedListQuene: Front");
        Node cur = head;
        while (cur!=null){
            sb.append(cur.e);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
