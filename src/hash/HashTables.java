package hash;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author zhoushuyi
 * @since 2018/7/3
 */
public class HashTables<K, V> {

    private TreeMap<K, V>[] kvTreeMap;
    private int size;
    private int m;


    public HashTables(int m) {
        this.m = m;
        kvTreeMap = new TreeMap[m];
        for (size = 1; size <= m; size++) {
            kvTreeMap[size-1] = new TreeMap<>();
        }
    }

    public HashTables() {
        this(16);
    }


    public void put(K key,V value) {
        TreeMap<K, V> em = kvTreeMap[hash(key)];

        if (em.containsKey(key)) {
            em.put(key, value);
        }else{
            em.put(key, value);
            size++;
        }
    }

    public V get(K key) {
        TreeMap<K, V> em = kvTreeMap[hash(key)];
        return em.get(key);
    }


    public V remove(K key, V value) {
        TreeMap<K, V> em = kvTreeMap[hash(key)];
        if (em.containsKey(key)) {
            size--;
            return em.remove(key);
        }
        return null;
    }

    public boolean contains(K key) {
        TreeMap<K, V> em = kvTreeMap[hash(key)];
        return em != null;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    private int hash(K key){
        return key == null ? 0 : (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HashTables{");
        sb.append(kvTreeMap == null ? "null" : Arrays.asList(kvTreeMap).toString());
        sb.append('}');
        return sb.toString();
    }
}
