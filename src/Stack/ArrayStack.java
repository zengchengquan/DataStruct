package Stack;

import Array.Array;
import Interface.Stack;

/**
 * Created by zeng.chengquan on 2018/5/19 0019.
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capcity) {
        array = new Array(capcity);
    }

    public ArrayStack(){
        array = new Array();
    }


    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E top() {
        return array.getLast();
    }

    @Override
    public E pop() {
        return array.removeLastElement();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Interface.Stack:");
        sb.append("[");
        for (int i=0;i<array.getSize();i++){
            sb.append(array.get(i));
            if(i !=getSize()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        sb.append("top");
        return sb.toString();
    }
}
