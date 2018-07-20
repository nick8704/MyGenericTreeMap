package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyTreeSet<K> {

    private MyTreeMap<K, Object> map = new MyTreeMap<>();
    List<K> list = new ArrayList<>();
    private final int DEFAULT_INT = 0;

    public void add(K k) {
        map.put(k, DEFAULT_INT);
        list.add(k);
    }

    public void remove(K k) {
        map.remove(k);
        list.remove(k);
    }

    public int size() {
        return map.size();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public void clear() {
        map.clear();
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}