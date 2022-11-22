package org.example;

import java.util.Objects;

public class StringListImpl implements StringList{

    private static final int arraySize = 10;

    private String[] array;

    private int currentSize;

    public StringListImpl() {
        this(arraySize) ;
    }

    public StringListImpl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Рамер массива должен быть положительным");
        }
        array = new String[n];
        currentSize = 0;
    }

    public void cheсkItemNull(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя хранить null");
        }

    }

    public void checkNegativIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть положителиным");
        }
    }


    @Override
    public String add(String item) {
        return add(currentSize,item);
    }

    @Override
    public String add(int index, String item) {
        if (currentSize >= array.length) {
            throw new IllegalArgumentException("Массив полон");
        }
        cheсkItemNull(item);
        checkNegativIndex(index);
        if (index > currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        System.arraycopy(array,index,array,index+1,currentSize-index);
        array[index]= item;
        currentSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        cheсkItemNull(item);
        checkNegativIndex(index);
        if (index >= currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        return array[index] = item;
    }

    @Override
    public String remove(String item) {
        int indexItem = indexOf(item);
        if (indexItem == -1) {
            throw new IllegalArgumentException("Элемент не найден");
        }
        return remove(indexItem);
    }

    @Override
    public String remove(int index) {
        checkNegativIndex(index);
        if (index >= currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        String removed = array[index];
        System.arraycopy(array,index+1,array,index,currentSize-index-1);
        array[--currentSize] = null;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        cheсkItemNull(item);
        int index= -1;
        for (int i = 0; i < currentSize; i++) {
            if (array[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        cheсkItemNull(item);
        int index= -1;
        for (int i = currentSize - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        checkNegativIndex(index);
        if (index >= currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < currentSize; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[currentSize];
        System.arraycopy(array,0,newArray,0,currentSize);
        return newArray;
    }
}
