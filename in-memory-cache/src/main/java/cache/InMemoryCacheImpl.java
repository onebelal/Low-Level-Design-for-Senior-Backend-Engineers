package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryCacheImpl<K, V> implements InMemoryCache<K,V>{

    private Map<K, CacheValue<V>> cache;
    private EvictionPolicy<K> evictionPolicy;
    private final int capacity;
    public InMemoryCacheImpl(EvictionPolicy<K> evictionPolicy, int capacity) {
        cache = new HashMap<>();
        this.evictionPolicy=evictionPolicy;
        this.capacity=capacity;
        ScheduledExecutorService executors = Executors.newSingleThreadScheduledExecutor();
        executors.scheduleAtFixedRate(this::deleteExpiredKeys, 60, 60, TimeUnit.MINUTES);
    }

    @Override
    public void put(K k, V v, long ttl) {
        if(cache.size()>=capacity) {
           K k1 = evictionPolicy.getEvictKey();
           evictionPolicy.keyRemoved(k1);
        }
        cache.put(k, new CacheValue<>(v, ttl));
        evictionPolicy.updateEvictionStorage(k);
    }

    @Override
    public V get(K k) {
        CacheValue<V> entry = cache.get(k);
        if (entry == null) {
            return null;
        }
        if(entry.isKeyExpired()) {
            evictionPolicy.keyRemoved(k);
            cache.remove(k);
            return null;
        }
        evictionPolicy.updateEvictionStorage(k);
        return entry.getValue();
    }


    private void deleteExpiredKeys() {
        cache.entrySet().removeIf(e->e.getValue().isKeyExpired());
    }
}
