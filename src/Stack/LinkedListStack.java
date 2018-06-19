package Stack;

import Interface.Stack;
import LinkedList.LinkedList;

/**
 * Created by zeng.chengquan on 2018/5/29 0029.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> stack;

    public LinkedListStack() {
        stack = new LinkedList<E>();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public E top() {
        return stack.getFirst();
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public void push(E e) {
        stack.addFirst(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack.LinkedListStack: Front");
        sb.append(stack);
        return sb.toString();
    }
}
