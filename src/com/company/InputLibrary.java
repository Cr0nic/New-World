package com.company;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public final class InputLibrary {
    //private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Scanner reader = new Scanner(System.in);

    /*static BufferedReader getReader() {
        return reader;
    }

     */
    static Scanner getReader(){
        return reader;
    }
}
