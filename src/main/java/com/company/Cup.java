package com.company;

public class Cup {
    private int volume;
    private int size;

    public Cup(int volume) {
        this.volume = volume;
    }

    public int getSize() {
        return size;
    }

    public int getVolume() {
        return volume;
    }

    public int getRemain() {
        return volume - size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == volume;
    }

    public void fill() {
        size = volume;
    }

    public void empty() {
        size = 0;
    }

    public void fillOut(int s) {
        size -= s;
    }

    public void fillIn(int s) {
        size += s;
    }

}
