package com.rwtema.funkylocomotion.helper;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakSet<E> extends AbstractSet<E> implements Set<E> {
    private final WeakHashMap<E, Object> map = new WeakHashMap<E, Object>();
    private static final Object BLANK = new Object();

    @Override
    public boolean add(E e) {
        return map.put(e, BLANK) == null;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == BLANK;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
