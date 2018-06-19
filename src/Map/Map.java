package Map;

/**
 * Created by zeng.chengquan on 2018/6/19 0019.
 */
public interface Map<K,V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
