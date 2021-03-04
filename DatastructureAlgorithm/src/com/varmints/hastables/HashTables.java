package com.varmints.hastables;

import com.varmints.arrays.Array;

import java.util.*;
import java.util.function.Consumer;

class Entry<K, V> {
    K key;
    V val;
    int hashCode;

    public Entry(K key, V val) {
        this.key = key;
        this.val = val;
        this.hashCode = key.hashCode();
    }

    public boolean equals(Entry<K, V> otherHash) {
        if (hashCode == otherHash.hashCode)
            return key.equals(otherHash.key);
        return false;
    }

    @Override
    public String toString() {
        return key + " => " + val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val, hashCode);
    }
}

public class HashTables<K, V> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<Entry<K, V>>[] table;

    public HashTables() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTables(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.maxLoadFactor = loadFactor;
        threshold = (int) (capacity * loadFactor);
        table = new LinkedList[capacity];
    }

    public HashTables(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int normalizeIndex(int hash) {
        return (hash * 0X7FFFFFF) % capacity;
    }

    private void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(K key) {
        return hasKey(key);
    }

    private boolean hasKey(K key) {
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketSeekEnrty(bucketIndex, key) != null;
    }

    public V put(K k, V v) {
        return insert(k, v);
    }

    public V add(K k, V v) {
        return insert(k, v);
    }

    public V get(K k) {
        if (k == null) throw new IllegalArgumentException("Key cannot be null");
        int bucketIndex = normalizeIndex(k.hashCode());
        Entry<K, V> entry = bucketSeekEnrty(bucketIndex, k);
        if (entry != null) return entry.val;
        return null;
    }

    public V remove(K k) {
        if (k == null) throw new IllegalArgumentException("Key cannot be null");
        int bucketIndex = normalizeIndex(k.hashCode());
        return bucketRemoveEntry(bucketIndex, k);
    }

    private V bucketRemoveEntry(int bucketIndex, K k) {
        Entry<K, V> entry = bucketSeekEnrty(bucketIndex, k);
        if (entry == null) {
            return null;
        }
        table[bucketIndex].remove(entry);
        return entry.val;
    }

    public V insert(K k, V v) {
        if (k == null) throw new IllegalArgumentException("Key cannot be null");
        Entry<K, V> kvEntry = new Entry<>(k, v);
        int bucketIndex = normalizeIndex(kvEntry.hashCode);
        return bucketInsert(bucketIndex, kvEntry);
    }

    private V bucketInsert(int bucketIndex, Entry<K, V> kvEntry) {
        LinkedList<Entry<K, V>> row = table[bucketIndex];
        if (row == null) {
            row = new LinkedList();
            table[bucketIndex] = row;
        }
        Entry<K, V> seekEntry = bucketSeekEnrty(bucketIndex, kvEntry.key);
        if (seekEntry == null) {
            row.add(kvEntry);
            size++;
            if (size > threshold)
                resizeTable();
            return null;
        } else {
            seekEntry.val = kvEntry.val;
            return seekEntry.val;
        }
    }

    private void resizeTable() {
        capacity *= 2;
        threshold = (int) (capacity * maxLoadFactor);
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> item : table[i]) {
                    int bucketIndex = normalizeIndex(item.hashCode);
                    LinkedList<Entry<K, V>> linkedList = newTable[bucketIndex];
                    if (linkedList == null) newTable[i] = linkedList = new LinkedList<>();
                    linkedList.add(item);
                }
            }
            table[i].clear();
            table[i] = null;
        }
        table = newTable;
    }

    private Entry<K, V> bucketSeekEnrty(int bucketIndex, K key) {
        LinkedList<Entry<K, V>> list = table[bucketIndex];
        if (list == null) return null;
        for (Entry<K, V> item : list) {
            if (item.key.equals(key)) return item;
        }
        return null;
    }

    public ArrayList<K> keys() {
        ArrayList<K> list = new ArrayList<>(size);
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    list.add(entry.key);
                }
            }
        }
        return list;
    }

    public ArrayList<V> values() {
        ArrayList<V> list = new ArrayList<>(size);
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    list.add(entry.val);
                }
            }
        }
        return list;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super K> action) {

    }

    @Override
    public Spliterator<K> spliterator() {
        return null;
    }
}
