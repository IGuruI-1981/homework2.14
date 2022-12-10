package org.example;



public class Main {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl();

        Sorting sorting = new Sorting();

        integerList.add(3);
        integerList.add(7);
        integerList.add(32);
        integerList.add(-43);
        integerList.add(-3);

//   3,7,32,-43,-3

        integerList.add(2, 4);
        System.out.println(integerList.contains(7));
        System.out.println(integerList.contains(53));
        System.out.println(integerList.contains(-3));





//
//        double timeSortBubble = sorting.timeSorting(5, Sorting::sortBubble);
//        System.out.println("Среднее время соритровки пузырьком: " + timeSortBubble + " мс");
//        double timeSortSelection = sorting.timeSorting(5, Sorting::sortSelection);
//        System.out.println("Среднее время соритровки выбором: " + timeSortSelection + " мс");
//        double timeSortInsertion = sorting.timeSorting(5, Sorting::sortInsertion);
//        System.out.println("Среднее время соритровки вставкой: " + timeSortInsertion + " мс");
//        double timeQuickSort = sorting.timeSorting(5, arr -> Sorting.quickSort(arr));
//        System.out.println("Среднее время соритровки пузырьком: " + timeQuickSort + " мс");

    }
}