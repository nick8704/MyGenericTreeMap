package com.company;

public class Main {

    public static void main(String[] args) {

        testMyTreeMap();

        System.out.println("==============================");

        testMyTreeSet();
    }

    private static void testMyTreeMap() {
        MyTreeMap<String, Integer> myTreeMap = new MyTreeMap<>();
        myTreeMap.put("one", 1);
        myTreeMap.put("two", 2);
        myTreeMap.put("three", 3);
        myTreeMap.put("four", 4);
        myTreeMap.put("five", 5);
        myTreeMap.remove("three");

        System.out.println(myTreeMap.size());
        System.out.println(myTreeMap);
        System.out.println(myTreeMap.containsValue(6));
        System.out.println(myTreeMap.containsKey("five"));
    }

    private static void testMyTreeSet() {
        MyTreeSet<Character> myTreeSet = new MyTreeSet<>();
        myTreeSet.add('c');
        myTreeSet.add('d');
        myTreeSet.add('b');
        myTreeSet.add('g');
        myTreeSet.add('e');
        myTreeSet.add('f');
        myTreeSet.add('a');
        myTreeSet.remove('g');

        System.out.println(myTreeSet.size());
        System.out.println(myTreeSet);
        System.out.println(myTreeSet.contains('e'));
    }

}