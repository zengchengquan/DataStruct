package Interface;

/**
 * Created by zeng.chengquan on 2018/5/19 0019.
 */
public interface Stack<E> {
    boolean isEmpty();
    int getSize();
    E top();
    E pop();
    void push(E e);
}
