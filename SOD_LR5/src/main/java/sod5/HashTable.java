package sod5;

import java.util.Arrays;

public class HashTable {

    private int size;
    private Bucket[] buckets;
    private int capacity;


    public HashTable() {
        capacity = 16;
        size = 0;
        buckets = new Bucket[capacity];
    }


    public void add(String value) {
        if ((double) size / capacity >= 0.75) {
            doubleArray();
        }

        int hash = Math.abs(value.hashCode()) % buckets.length;

        if (buckets[hash] == null) {
            buckets[hash] = new Bucket();
        }

        buckets[hash].add(value);

        size++;
    }

    public void remove(String value) {
        if ((double) size / capacity >= 0.75) {
            doubleArray();
        }
        int hash = Math.abs(value.hashCode()) % buckets.length;
        if (buckets[hash] != null) {
            buckets[hash].remove(value);
            size--;
        }
    }

    public String find(String value){
        String res = ":(";
        int hash = Math.abs(value.hashCode()) % buckets.length;
        if (buckets[hash] != null) {
            res = buckets[hash].findElement(value);
        }
        return res;
    }

    private void doubleArray() {
        capacity *= 2;
        size = 0;
        Bucket[] smallTable = buckets;
        buckets = new Bucket[capacity];
        System.arraycopy(smallTable, 0, buckets, 0, smallTable.length);
    }

    @Override
    public String toString() {
        return "HashTable"
                + Arrays.toString(buckets);
    }
}
