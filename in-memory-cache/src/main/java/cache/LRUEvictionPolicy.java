package cache;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{

    private final HashSet<K> order = new LinkedHashSet<>();

    @Override
    public void updateEvictionStorage(K key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public K getEvictKey() {
        K first = order.iterator().next();
        order.remove(first);
        return first;
    }

    @Override
    public void keyRemoved(K key) {
        order.remove(key);
    }
}
