package Interface;

/**
 * Created by zeng.chengquan on 2018/5/21 0021.
 */
public interface Quene<E> {
    boolean isEmpty();
    int getSize();
    E getFront();
    E dequene();
    void enquene(E e);
}
