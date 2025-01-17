package com.veda.map;

import java.util. * ;
class Bucket {
    List<Pair<Integer, Integer>> pairs;
    // Initialize bucket here
    public Bucket() {
        pairs = new ArrayList<>();
    }
    // put value in bucket
    public void update(int key, int value) {
        for(Pair<Integer, Integer> pair: pairs) {
            if(pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        Pair<Integer, Integer> pair = new Pair<>(key, value);
        pairs.add(pair);
    }
    // get value from bucket
    public int get(int key) {
        for(Pair<Integer, Integer> pair: pairs) {
            if(pair.getKey() == key) return pair.getValue();
        }
        return -1;
    }
    // delete value from bucket
    public void remove(int key) {
        for(int i = 0; i < pairs.size(); i++) {
            if(pairs.get(i).getKey() == key) {
                pairs.remove(i);
                return;
            }
        }
    }
}

class Pair<K,V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }
}