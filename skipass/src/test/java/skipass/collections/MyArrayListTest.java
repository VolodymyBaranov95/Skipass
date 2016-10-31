package ua.yandex.skipass.collections;

import ua.yandex.skipass.collections.NotEnoughIndexException;
import ua.yandex.skipass.collections.MyArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void addRandom() {
        MyArrayList list = new MyArrayList();
        list.add(5);
        list.add(10);
        list.add(20);
        Object expRes[] = list.toArray();
        Object actRes[] = {5, 10, 20};
        assertArrayEquals(actRes, expRes);
    }

    @Test
    public void addRandomValue() {
        MyArrayList list = new MyArrayList(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 2, 3, 3, 3};
        assertArrayEquals(actRes, expRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void getNedativeIndex() {
        MyArrayList list = new MyArrayList();
        list.get(-10);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void getOutputSize() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(5);
        list.get(4);
    }

    @Test
    public void getRandom() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        Object expRes = list.get(0);
        Integer actRes = Integer.valueOf(10);
        assertEquals(actRes, expRes);
    }

    @Test
    public void getRandomValue() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        Object expRes = list.get(2);
        Integer actRes = Integer.valueOf(30);
        assertEquals(actRes, expRes);
    }

    @Test
    public void get() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        Object expRes = list.get(0);
        Integer actRes = Integer.valueOf(1);
        assertEquals(expRes, actRes);
    }

    @Test
    public void addIndexRandom() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2, 10);
        Object actRes = list.get(2);
        Integer expRes = Integer.valueOf(10);
        assertEquals(actRes, expRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void addIndexOutputSize() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(3, 30);
    }

    @Test
    public void addIndexRandomValue() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(1, 30);
        Integer actRes = Integer.valueOf(20);
        Object expRes = (Integer) list.get(2);
        assertEquals(actRes, expRes);
    }

    @Test
    public void addAllRandom() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 2, 3};
        assertArrayEquals(expRes, actRes);
    }

    @Test
    public void addAllCheckSize() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        int expRes = list.size();
        int actRes = 3;
        assertEquals(expRes, actRes);
    }

    @Test
    public void addAllIndexRandomValue() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(0, mas);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 2, 3};
        assertArrayEquals(actRes, expRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void addAllIndexExpectException() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2};
        list.addAll(1, mas);
    }

    @Test
    public void addAllIndexCheckFirst() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2};
        list.addAll(0, mas);
        Object expRes = list.get(0);
        Integer actRes = Integer.valueOf(1);
        assertEquals(expRes, actRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void removeOutputSize() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        list.remove(4);
    }

    @Test
    public void removeRandom() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        Object expRes = list.remove(1);
        Integer actRes = Integer.valueOf(1);
        assertEquals(expRes, actRes);
    }

    @Test(expected = NotEnoughIndexException.class)
    public void setOutputSize() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        list.set(4, 50);
    }

    @Test
    public void set() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3};
        list.addAll(mas);
        list.set(1, 50);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 50, 3};
        assertArrayEquals(expRes, actRes);
    }

    @Test
    public void indexOf() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        int expRes = list.indexOf(3);
        int actRes = 2;
        assertEquals(expRes, actRes);
    }

    @Test
    public void indexOfNotFound() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        int expRes = list.indexOf(10);
        int actRes = -1;
        assertEquals(expRes, actRes);
    }

    @Test
    public void sizeForEmptyList() {
        MyArrayList list = new MyArrayList();
        int expRes = list.size();
        int actRes = 0;
        assertEquals(expRes, actRes);
    }

    @Test
    public void sizeTest() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        int expRes = list.size();
        int actRes = 5;
        assertEquals(expRes, actRes);
    }

    @Test
    public void clear() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        list.clear();
        int expRes = list.size();
        int actRes = 0;
        assertEquals(expRes, actRes);
    }

    @Test
    public void isEmpty() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        assertFalse(list.isEmpty());
    }

    @Test
    public void isEmptyNotEmpty() {
        MyArrayList list = new MyArrayList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void toArray() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        Object expRes[] = list.toArray();
        Object actRes[] = {1, 2, 3, 4, 5};
        assertArrayEquals(actRes, expRes);
    }

    @Test
    public void toArrayForEmptyList() {
        MyArrayList list = new MyArrayList();
        Object expRes[] = list.toArray();
        Object actRes[] = new Object[0];
        assertArrayEquals(expRes, actRes);
    }

    @Test
    public void toStringRandom() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        String expRes = list.toString();
        String actRes = "1,2,3,4,5";
        assertEquals(expRes, actRes);
    }

    @Test
    public void toStringForEmptyList() {
        MyArrayList list = new MyArrayList();
        String expRes = list.toString();
        String actRes = "";
        assertEquals(expRes, actRes);
    }

    @Test
    public void ensureCapacity() {
        MyArrayList list = new MyArrayList();
        Object mas[] = {1, 2, 3, 4, 5};
        list.addAll(mas);
        list.ensureCapacity(5);
        int expRes = list.tempCapacity();
        int actRes = 10;
        assertTrue(expRes - actRes > 0);
    }
}
