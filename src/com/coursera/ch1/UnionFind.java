package com.coursera.ch1;

public interface UnionFind {

    void union(int p, int q); // union between two points p & q

    boolean connected(int p, int q); //Check if p & q are connected.

    void print (); // print the array

    public static  void main(String args []) {
        // read the input from file. unionFindTest.txt
        // first entry is the count
        // next entries are for unions
    }
}
