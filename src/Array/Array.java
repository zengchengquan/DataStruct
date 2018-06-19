package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeng.chengquan on 2018/5/11 0011.
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (size == data.length) {
            resize(2*data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed ,Require index >=0 and index <=size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int i) {
        E[] newData = (E[]) new Object[i];
        for (int j = 0; j<size; j++){
            newData[j] = data[j];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index is illegal");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(int e){
        for(int i=0;i < size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for(int i=0;i < size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList findAll(int e){
        ArrayList arrayList  = new ArrayList<Integer>();
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public E removeElementByIndex(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("AddLast failed ,Require index >=0 and index <=size");
        }
        E ret = data[index];
        for (int i=index;i<size-1;i++){
            data[i] = data[i+1];
        }
        data[size-1]=null;
        size--;
        if(size==data.length/4 && (data.length/2)!=0){
            resize(data.length/2);
        }
        return ret;
    }

    public  E removeFirstElement(){
        return removeElementByIndex(0);
    }

    public  E removeLastElement(){
        return removeElementByIndex(size-1);
    }

    public void  removeElement(E e){
        int index = find(e);
        if(index !=-1){
            removeElementByIndex(index);
        }
    }

    public void removeAllElement(int e){
        for (int i=0;i<size;i++){
            if(data[i].equals(e)){
                removeElementByIndex(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array.Array:size = %d,capacity = %d ", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
