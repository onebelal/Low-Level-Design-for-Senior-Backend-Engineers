package cache;

public interface EvictionPolicy<K> {

    void updateEvictionStorage(K key);
    K getEvictKey();
    void keyRemoved(K key);
}
