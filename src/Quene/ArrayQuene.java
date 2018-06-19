package Quene;

import Array.Array;
import Interface.Quene;

/**
 * Created by zeng.chengquan on 2018/5/21 0021.
 */
public class ArrayQuene<E> implements Quene<E> {
    Array<E> quene;

    public ArrayQuene(int capcity) {
        quene = new Array<E>(capcity);
    }

    public ArrayQuene(){
        quene = new Array<E>();
    }

    @Override
    public boolean isEmpty() {
        return quene.isEmpty();
    }

    @Override
    public int getSize() {
        return quene.getSize();
    }

    @Override
    public E getFront() {
        return quene.getFirst();
    }

    @Override
    public E dequene() {
        return quene.removeFirstElement();
    }

    @Override
    public void enquene(E e) {
        quene.addLast(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Interface.Quene:");
        sb.append("front[");
        for (int i=0;i<quene.getSize();i++){
            sb.append(quene.get(i));
            if(i !=getSize()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        sb.append("tail");
        return sb.toString();
    }
}
