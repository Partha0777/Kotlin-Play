package com.curiozing.kotlinplay.kotlinVsJava.conciseness;

import java.util.ArrayList;
import java.util.List;

public class ConcisenessInJava {
    public static void main(String[] args) {
        listMethod();
    }

    static void listMethod() {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);

        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) % 2 == 0) {
                evenNumbers.add(data.get(i));
            }
        }
        System.out.println("Data even " + evenNumbers);
    }
}


