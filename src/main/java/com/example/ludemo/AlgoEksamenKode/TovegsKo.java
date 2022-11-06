package com.example.ludemo.AlgoEksamenKode;

public interface TovegsKo<E> {
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();
    E getFirst();
    E getLast();
    int size();
    boolean isEmpty();
}
