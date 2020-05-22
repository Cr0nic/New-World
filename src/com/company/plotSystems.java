package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class plotSystems{

    public static void execution(Player player) throws IOException {

       // BufferedReader reader = InputLibrary.getReader();
        Scanner input = InputLibrary.getReader();


        int plot_price = 50;
        int plot_sell_price = 45;


        try{
            while (input.hasNextLine()) {
                printStats.print(player);


                System.out.println("1. Land kaufen");
                System.out.println("2. Land verkaufen");
                System.out.println("3. Zurueck");

                //String line = reader.readLine();
                //int player_action2 = Integer.parseInt(line);

                int player_action2 = input.nextInt();

                // Land kaufen
                if (player_action2 == 1) {
                    printStats.print(player);


                    System.out.println("Wie viel Land soll gekauft werden? ");


                    //String line2 = reader.readLine();
                    //int buying_player = Integer.parseInt(line2);

                    int buying_player = input.nextInt();

                    // zu viele if statements ?
                    if (buying_player > 0) {

                        int check_enough_money = player.money - plot_price * buying_player;
                        if (check_enough_money > 0) {
                            player.money = check_enough_money;
                            player.plot = player.plot + buying_player;


                        }

                    }

                    // Land verkaufen
                } else if (player_action2 == 2) {
                    printStats.print(player);


                    System.out.println("Wie viel Land soll verkauft werden? ");

                    //String line3 = reader.readLine();
                    //int selling_plot_amount = Integer.parseInt(line3);


                    int selling_plot_amount = input.nextInt();

                    if (selling_plot_amount > 0) {

                        int check_enough_plot = player.sellable_plot - selling_plot_amount;

                        if (check_enough_plot >= 0) {
                            player.money = player.money + plot_sell_price * selling_plot_amount;
                            player.plot = player.plot - selling_plot_amount;
                            player.sellable_plot = player.sellable_plot - selling_plot_amount;

                        }

                    }

                } else if (player_action2 == 3) {
                    break;
                }

            }
        }catch (Exception e){
            input.close();
        }

    }
}