package com.company;

public class printStats {
    public static void print(Player player){

        System.out.printf("Siedler: %d | Geld: %d | Land: %d (Preis: %d/%d)" +"\n\n"+ "Maschinen %8s %7s %7s\n",player.siedler,
                player.money, player.plot,resourcePrices.getBuyPrice(0), resourcePrices.getSellPrice(0), "Anzahl","Vorrat", "Preis");
        // Printen aller Rohstoffe in einzelnen Zeilen für mehr Übersicht

        System.out.printf( "Getreide %9d %7d %4d/%d\n" ,player.machine_assignment.get(1) ,player.resources.get(1), resourcePrices.getBuyPrice(1),resourcePrices.getSellPrice(1));
        System.out.printf( "\u00D6l %15d %7d %4d/%d\n", player.machine_assignment.get(2),player.resources.get(2), resourcePrices.getBuyPrice(2),resourcePrices.getSellPrice(2));
        System.out.printf( "Metall %11d %7d %4d/%d\n",player.machine_assignment.get(3) ,player.resources.get(3), resourcePrices.getBuyPrice(3),resourcePrices.getSellPrice(3));
        System.out.printf( "Kristall %9d %7d %4d/%d\n",player.machine_assignment.get(4) ,player.resources.get(4), resourcePrices.getBuyPrice(4),resourcePrices.getSellPrice(4));
        System.out.printf( "Frei %13d\n\n" + "---" + "\n\n",player.machine_assignment.get(0));

    }
}
