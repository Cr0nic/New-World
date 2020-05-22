package com.company;

import java.util.HashMap;
import java.util.Hashtable;

public class resourcePrices {
    public int plot_price = 50;
    public int grain_price = 25;
    public int oil_price = 50;
    public int metal_price = 60;
    public int crystal_price = 75;
    int[] prices = {50,25,50,60,75};

    public static int getBuyPrice(int input){
        int[] prices = {50,25,50,60,75};
        return prices[input];

    }

    public static int getSellPrice(int input){
        int[] prices = {50,25,50,60,75};

        float x = prices[input];
        x = x * 0.9f;
        int y = (int) x;
        return y;



    }


}
