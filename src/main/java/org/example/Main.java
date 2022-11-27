package org.example;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();

        stringList.add("34");
        stringList.add("54");
        stringList.add("64");
        stringList.add("84");

        stringList.add(1, "45");

        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();
        stringList.remove(3);
        stringList.remove("54");
        System.out.println("=====");


        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + " ");
        }
        System.out.println();
        System.out.println("=====");

        stringList.clear();

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        System.out.println("Массив пустой");


    }
}