package Set;

/**
 * Created by zeng.chengquan on 2018/6/19 0019.
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int  getSize();
    boolean isEmpty();
}
