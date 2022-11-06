package com.example.ludemo.AlgoEksamenKode;

public class TabellTovegsKo<E> implements TovegsKo<E> {
    private static final int DEFAULT_SIZE = 20;
    private static final double EXPAND_MULTIPLIER = 1.5;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private int size = 0;
    private E[] elements;
    public TabellTovegsKo() {
        elements = (E[]) new Object[DEFAULT_SIZE];
    }
    public TabellTovegsKo(int size) {
        elements = (E[]) new Object[size];
    }
    @Override
    public void addFirst(E element) {
        expand();
        if(firstIndex<=0){
            firstIndex+=elements.length;
        }
        size++;
        elements[--firstIndex % elements.length] = element;
    }
    @Override
    public void addLast(E element) {
        expand();
        size++;
        elements[++lastIndex % elements.length] = element;
    }
    @Override
    public E removeFirst() {
        size--;
        return elements[firstIndex++ % elements.length];
    }
    @Override
    public E removeLast() {
        size--;
        return elements[lastIndex--% elements.length];
    }
    @Override
    public E getFirst() {
        return elements[firstIndex % elements.length];
    }
    @Override
    public E getLast() {
        return elements[lastIndex % elements.length];
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size()<=0;
    }
    private void expand() {
        if(size < elements.length) return;
        E[] tmp = (E[]) new Object[(int)(EXPAND_MULTIPLIER* elements.length)];
        int tmpIndex = 0;
        for (int i = firstIndex % elements.length; i < elements.length; i++) {
            tmp[tmpIndex++] = elements[i];
        }
        for (int i = 0; i < firstIndex % elements.length; i++) {
            tmp[tmpIndex++] = elements[i];
        }
        elements = tmp;
        firstIndex = 0;
        lastIndex = size-1;
    }
}
