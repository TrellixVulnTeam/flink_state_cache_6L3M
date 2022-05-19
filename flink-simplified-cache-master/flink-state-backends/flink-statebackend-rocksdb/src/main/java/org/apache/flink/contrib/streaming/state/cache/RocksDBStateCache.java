package org.apache.flink.contrib.streaming.state.cache;

import org.apache.commons.math3.util.Pair;

/** Javadoc for RocksDBStateCache. */
public class RocksDBStateCache<V> {

    private AbstractCacheManager<V> cacheManager;

    private final int defaultSize = 4000;

    public RocksDBStateCache() {
        this.cacheManager = CacheManagerFactory.getDefaultCacheManager(defaultSize);
    }

    public RocksDBStateCache(int size) {
        this.cacheManager = CacheManagerFactory.getDefaultCacheManager(size);
    }

    // gets value related to key
    public boolean has(byte[] key) {
        return cacheManager.has(key);
    }

    // gets value related to key
    public V get(byte[] key) {
        return cacheManager.get(key);
    }

    // evict value with such key
    public void remove(byte[] key) {
        cacheManager.remove(key);
    }

    // puts kv pair, returns evicted pair
    public Pair<byte[], V> update(byte[] key, V value) {
        return cacheManager.update(key, value);
    }

    public void clear() {}
}
