package ua.yandex.skipass.collections;

import java.util.*;
import ua.yandex.skipass.collections.MyList;

public class MyArrayList implements MyList {

    private Object[] elementData;
    private int size;

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public int tempCapacity() {
        return this.elementData.length;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity * 2);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        Object[] array = new Object[newCapacity];
        System.arraycopy(this.elementData, 0, array, 0,
                this.elementData.length);
        this.elementData = array;
    }

    public boolean checkIndex(int index) throws NotEnoughIndexException {
        if (index > size || index < 0) {
            throw new NotEnoughIndexException();
        }
        return true;
    }

    public void add(Object e) {
        ensureCapacity(size + 1);
        elementData[size] = e;
        size++;
    }

    public void add(int index, Object e) {
        checkIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    public void addAll(Object c[]) {
        ensureCapacity(size + c.length);
        System.arraycopy(c, 0, this.elementData, this.size, c.length);
        size = size + c.length;
    }

    public void addAll(int index, Object c[]) {
        checkIndex(index);
        ensureCapacity(size + c.length);
        System.arraycopy(this.elementData, index, this.elementData,
                index + c.length, this.size - index);
        System.arraycopy(c, 0, this.elementData, index, c.length);
        this.size += c.length;
    }

    public Object get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    public Object remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index, elementData, index + 1, numMoved);
        elementData[--size] = null;
        return numMoved;
    }

    public int size() {
        return this.size;
    }

    public void set(int index, Object e) {
        checkIndex(index);
        elementData[index] = e;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elementData[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                result.append(",");
            }
            result.append(this.elementData[i]);
        }
        return result.toString();
    }
}
