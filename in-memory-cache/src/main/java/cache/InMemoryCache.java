package cache;

public interface InMemoryCache<K,V> {

    void put(K k, V v, long ttl);
    V get(K k);
}
