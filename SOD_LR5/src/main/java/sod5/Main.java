package sod5;

import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        HashSet<String> hashSet = new HashSet<>();
        Random random = new Random();

        //час додавання 10^6 елементів до створеної таблиці
        long addInMyHashTableSTART = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String value = String.valueOf(random.nextInt(1000));
            hashTable.add(value);
        }
        long addInMyHashTableFINISH = System.currentTimeMillis();
        System.out.println("Add 10^6 elements in my HashTable: " + (addInMyHashTableFINISH - addInMyHashTableSTART));

        //час додавання 10^6 елементів Java HashSet
        long addInJavaHashSetSTART = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String value = String.valueOf(random.nextInt(1000));
            hashSet.add(value);
        }
        long addInJavaHashSetFINISH = System.currentTimeMillis();
        System.out.println("Add 10^6 elements In Java HashSet: " + (addInJavaHashSetFINISH - addInJavaHashSetSTART));


        String randElement = String.valueOf(random.nextInt(1000));

        //час пошуку випадкового значення в створеній хеш таблиці
        long findInMyHashTableSTART = System.currentTimeMillis();
        String check1 = hashTable.find(randElement);
        long findInMyHashTableFINISH = System.currentTimeMillis();

        System.out.println(check1);
        System.out.println("Find element In my Hash Table: " + (findInMyHashTableFINISH - findInMyHashTableSTART));

        //час пошуку випадкового значення в Java HashSet
        long findInJavaHashSetSTART = System.currentTimeMillis();
        boolean check2 = hashSet.contains(randElement);
        long findInJavaHashSetFINISH = System.currentTimeMillis();

        if (check2) System.out.println("+");
        System.out.println("Find element In Java HashSet: " + (findInJavaHashSetFINISH - findInJavaHashSetSTART));
    }
}