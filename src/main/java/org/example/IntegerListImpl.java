package org.example;

import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private static final int ARRAY_SIZE = 10;

    private Integer[] array;

    private int currentSize;

    public IntegerListImpl() {
        this(ARRAY_SIZE) ;
    }

    public IntegerListImpl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Рамер массива должен быть положительным");
        }
        array = new Integer[n];
        currentSize = 0;
    }

    public void cheсkItemNull(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя хранить null");
        }

    }

    public void checkNegativIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть положителиным");
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }



    private void grow() {
        Integer[] newArray = new Integer[(int)(array.length * 1.5)];
        System.arraycopy(array,0,newArray,0,currentSize);
        array = newArray;
    }

    @Override
    public Integer add(Integer item) {
        return add(currentSize,item);
    }

    @Override
    public Integer add(int index, Integer item) {
        if (currentSize >= array.length) {
            grow();
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
    public Integer set(int index, Integer item) {
        cheсkItemNull(item);
        checkNegativIndex(index);
        if (index >= currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        return array[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        int indexItem = indexOf(item);
        if (indexItem == -1) {
            throw new IllegalArgumentException("Элемент не найден");
        }
        return remove(indexItem);
    }

    @Override
    public Integer remove(int index) {
        checkNegativIndex(index);
        if (index >= currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        Integer removed = array[index];
        System.arraycopy(array,index+1,array,index,currentSize-index-1);
        array[--currentSize] = null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        cheсkItemNull(item);

        Integer[] arrayForContains = toArray();
        Sorting.quickSort(arrayForContains,0,arrayForContains.length-1);

        int min = 0;
        int max = arrayForContains.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(arrayForContains[mid])) {
                return true;
            }

            if (item < arrayForContains[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
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
    public int lastIndexOf(Integer item) {
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
    public Integer get(int index) {
        checkNegativIndex(index);
        if (index >= currentSize) {
            throw new IllegalArgumentException("Индекс выходит за пределы размера массива");
        }
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        Integer[] newArray = new Integer[currentSize];
        System.arraycopy(array,0,newArray,0,currentSize);
        return newArray;
    }
}
