package cache;

public class CacheValue<V> {
    private V v;
    private long expiry;

    public CacheValue(V v, long expiry) {
        this.v=v;
        this.expiry = System.currentTimeMillis()+expiry;
    }

    public V getValue() {
        return v;
    }
    public boolean isKeyExpired() {
        return System.currentTimeMillis() > expiry;
    }
}
