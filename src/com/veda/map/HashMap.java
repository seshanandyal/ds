package com.veda.map;
import java.util.*;

public class HashMap {
    private static int BUCKET_SIZE = 2551;
    private Bucket[] buckets;
    public HashMap() {
        // Write your code here
        buckets = new Bucket[BUCKET_SIZE];
        for(int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void put(int key, int value) {
        // Write your code here
        int hashKey = key % BUCKET_SIZE;
        buckets[hashKey].update(key, value);
    }

    public int get(int key) {
        // Replace this placeholder return statement with your code
        int hashKey = key % BUCKET_SIZE;
        return buckets[hashKey].get(key);
    }

    public void remove(int key) {
        int hashKey = key % BUCKET_SIZE;
        buckets[hashKey].remove(key);
    }
}