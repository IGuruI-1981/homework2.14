package org.example;



public class Main {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl();

        Sorting sorting = new Sorting();


        double timeSortBubble = sorting.timeSorting(5, Sorting::sortBubble);
        System.out.println("Среднее время соритровки пузырьком: " + timeSortBubble + " мс");
        double timeSortSelection = sorting.timeSorting(5, Sorting::sortSelection);
        System.out.println("Среднее время соритровки выбором: " + timeSortSelection + " мс");
        double timeSortInsertion = sorting.timeSorting(5, Sorting::sortInsertion);
        System.out.println("Среднее время соритровки вставкой: " + timeSortInsertion + " мс");

    }
}