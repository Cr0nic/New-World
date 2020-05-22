package com.company;
import java.util.*;

public class Player {
    public int money;
    public int plot;
    public int sellable_plot;
    public int grain;
    public int crystal;
    public int metal;
    public int oil;
    public int siedler;
    int machine_free;
    int machine_grain = 2;
    int machine_oil = 1;
    int machine_metal;
    int machine_crystal;
    String[] names = {"Getreide", "Öl", "Metall", "Kristall"};
   // public int[] resources = new int[4];
    HashMap<Integer, Integer> resources = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> machine_assignment = new HashMap<Integer, Integer>();




    public Player(int money, int plot, int grain, int oil, int metal, int crystal, int siedler){
        this.money = money;
        this.plot = plot;
        this.siedler = siedler;
        resources.put(1, grain);
        resources.put(2, oil);
        resources.put(3, metal);
        resources.put(4, crystal);
        machine_assignment.put(0, machine_free);
        machine_assignment.put(1, machine_grain);
        machine_assignment.put(2, machine_oil);
        machine_assignment.put(3, machine_metal);
        machine_assignment.put(4, machine_crystal);
        this.sellable_plot = plot - hashmap_add() ;



    }

    public int hashmap_add(){
        int sum = 0;
        for(int f:machine_assignment.values()){
            sum+=f;
        }
        return sum;
    }
    public String resource_names(int n){
        return names[n-1];

    }
}
