package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Player player = new Player(100,5,25,10,5,0,20);


        //BufferedReader reader = InputLibrary.getReader();
        Scanner input = InputLibrary.getReader();
        try{
            while(true) {

                // Main Menu
                printStats.print(player);

                System.out.println("1. Land verwalten");
                System.out.println("2. Maschinen verwalten");
                System.out.println("3. Markt besuchen");
                System.out.println("4. Runde beenden");


                int player_action = input.nextInt();
                //String line = reader.readLine();
                //int player_action = Integer.parseInt(line);



                if (player_action == 1) {

                    plotSystems.execution(player);

                }
                else if (player_action == 2){
                    Maschine.execution(player);
                }

                else if (player_action == 3) {
                    Market.execution(player);

                }else if (player_action == 4){

                    Beenden.execution(player);
                }

            }
        }catch(Exception e){
            input.close();

        }


    }
}
