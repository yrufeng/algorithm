package demo;

/**
 * @author yrf
 * @param <K>
 * @param <V>
 */
public interface IMyHashMap<K, V> {
    V put(K k, V v);

    V get(K k);

    int size();

    V remove(K k);

    boolean isEmpty();

    void clean();
}
