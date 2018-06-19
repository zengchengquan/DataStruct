package Quene;

import Interface.Quene;

/**
 * Created by zeng.chengquan on 2018/5/22 0022.
 */
public class LoopQuene<E> implements Quene<E> {

    private  E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQuene(int capcity) {
        data = (E[]) new Object [capcity+1];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQuene() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return tail==front;
    }

    @Override
    public int getSize() {
        return data.length-1;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public E dequene() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret;
        ret = data[front];
        data[front] = null;
        size--;
        front = (front+1)%(data.length);
        if(size==(getSize())/4&&(getSize()/2)!=0){
            resize(getSize()/2);
        }
        return ret;
    }

    @Override
    public void enquene(E e) {
        if((tail+1)%(data.length)==front){
            resize(2*(getSize()));
        }
        data[tail] = e;
        size++;
        tail = (tail+1)%(data.length);
    }

    private void resize(int capcity) {
        E [] newData = (E[])new Object[capcity+1];
        for(int i=0;i<size;i++){
            newData[i]=data[(front+i)%data.length];
        }
        data = newData;
        front=0;
        tail=size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quene.LoopQuene: ");
        sb.append(" size: "+size);
        sb.append(" capcity: "+(getSize()));
        sb.append(" front [");
        for (int i=0;i<size;i++){
            sb.append(data[(front+i)%(data.length)]);
            if(i !=size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        sb.append("tail");
        return sb.toString();
    }
}
