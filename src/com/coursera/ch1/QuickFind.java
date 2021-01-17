package com.coursera.ch1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickFind implements UnionFind {
    private int[] arrayOfValues;

    QuickFind(int n) {
        arrayOfValues = IntStream.range(0, n).toArray(); // create a stream of value 0 to n
    }

    @Override
    public void union(int p, int q) {
        if (connected(p ,q)) {
            return;
        }

        int pVal = arrayOfValues[p];
        int qVal = arrayOfValues[q];

        arrayOfValues = Arrays.stream(arrayOfValues).map(valueFromArr -> {
            if(valueFromArr == qVal) {
               return pVal;
            }
            return valueFromArr;
        }).toArray();

    }

    @Override
    public boolean connected (int p, int q) {
        return arrayOfValues[p] == arrayOfValues[q];
    }

    @Override
    public void print() {
        Arrays.stream(arrayOfValues).forEach(val -> System.out.print(" " + val));
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        qf.union (4,3);
        qf.union (3,8);
        qf.union (6,5);
        qf.union (9,4);
        qf.union (2,1);
        qf.union (5,0);
        qf.union (7,2);
        qf.union (6,1);
        qf.union (1,0);

        System.out.println();
        qf.print();
        System.out.println();

        System.out.println(qf.connected (0, 7)); //true
        System.out.println(qf.connected (2, 3)); // false
        System.out.println(qf.connected (2, 7)); // true
        System.out.println(qf.connected (1, 9)); // false
        System.out.println(qf.connected (5, 7)); // true
        System.out.println(qf.connected (7, 5)); // true
    }

}
