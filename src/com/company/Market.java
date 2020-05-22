package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class Market {
    public static void execution(Player player) throws IOException {
        Scanner input = InputLibrary.getReader();

        //BufferedReader reader = InputLibrary.getReader();
        //Getreide, Öl, Metall, Kristall
        int[] prices = {25,50,60,75};
        try{
            while (input.hasNextLine()) {

                printStats.print(player);


                System.out.println("1. Vorr\u00E4te kaufen");
                System.out.println("2. Vorr\u00E4te verkaufen");
                System.out.println("3. Zurueck");

                //String line = reader.readLine();
                //int player_action2 = Integer.parseInt(line);

                int player_action2 = input.nextInt();

                // KAUFMENÜ
                if (player_action2 == 1) {
                    printStats.print(player);


                    System.out.println("Welche Vorräte sollen gekauft werden?");
                    System.out.printf("1.Getreide\n2.Öl\n3.Metall\n4.Kristall\n5.Abbrechen\n");


                    //String line2 = reader.readLine();
                    //int resource_number = Integer.parseInt(line2);
                    int resource_number = input.nextInt();

                    if(resource_number == 5){
                        break;
                    }else {
                        System.out.printf("Wie viel %s soll gekauft werden? ",player.resource_names(resource_number));

                        // String line4 = reader.readLine();
                        //int amount = Integer.parseInt(line4);

                        int amount = input.nextInt();

                        // zu viele if statements ?
                        if (amount > 0) {
                            int check_enough_money = player.money - resourcePrices.getBuyPrice(resource_number) * amount;
                            if (check_enough_money >= 0) {
                                player.money = check_enough_money;
                                player.resources.put(resource_number, player.resources.get(resource_number) + amount);

                            }

                        }
                    }

                    // VERKAUFSMENÜ
                } else if (player_action2 == 2) {
                    printStats.print(player);


                    System.out.println("Welche Vorräte sollen verkauft werden?");
                    System.out.printf("1.Getreide\n2.Öl\n3.Metall\n4.Kristall\n5.Abbrechen\n");

                    //String line2 = reader.readLine();
                    //int resource_number = Integer.parseInt(line2);
                    int resource_number = input.nextInt();

                    if(resource_number == 5){
                        break;
                    }
                    else{
                        System.out.printf("Wie viel %s soll verkauft werden? ",player.resource_names(resource_number));


                        //String line3 = reader.readLine();
                        // int selling_amount = Integer.parseInt(line3);

                        int selling_amount = input.nextInt();

                        if (selling_amount > 0) {
                            int check_enough_resources= player.resources.get(resource_number) - selling_amount;

                            if (check_enough_resources >= 0){
                                //float sell = (float)prices[resource_number-1] *0.9f;
                                //int sell_price = (int)sell;

                                player.money = player.money + resourcePrices.getSellPrice(resource_number) * selling_amount;
                                player.resources.put(resource_number, check_enough_resources);


                            }
                        }


                    }


                } else if (player_action2 == 3) {
                    break;
                }

            }


        }catch(Exception e){
            input.close();
        }

    }
}
