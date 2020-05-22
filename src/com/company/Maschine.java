package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;


public class Maschine {
    public static void execution(Player player) throws IOException {
        Scanner input = InputLibrary.getReader();


        //BufferedReader reader = InputLibrary.getReader();



        try {
            while(input.hasNextLine()){
                printStats.print(player);

                System.out.println("1. Maschine(n) herstellen");
                System.out.println("2. Maschine(n) zuordnen");
                System.out.println("3. Maschine(n) freistellen");
                System.out.println("4. Zurück");

                //String line = reader.readLine();
                //int player_action2 = Integer.parseInt(line);
                int player_action2 = input.nextInt();


                if(player_action2 == 1){
                    System.out.print("Wie viele Maschinen sollen hergestellt werden?");
                    //String line2 = reader.readLine();
                    //int amount = Integer.parseInt(line2);
                    int amount = input.nextInt();


                    if((amount>0)){
                        int metal_used = player.resources.get(3) - amount;
                        int plot_used = player.plot - amount;
                        if(metal_used>=0 && plot_used >= 0){
                            player.resources.put(3,metal_used);
                            player.machine_assignment.put(0, player.machine_assignment.get(0) +amount);
                            player.sellable_plot = player.sellable_plot - amount;
                        }
                    }

                }


                else if(player_action2 == 2){
                    System.out.print("Wo sollen Maschinen zugeordnet werden?\n");
                    System.out.printf("1.Getreide\n2.Öl\n3.Metall\n4.Kristall\n5.Abbrechen\n");

                    //String line2 = reader.readLine();
                    //int resource_number = Integer.parseInt(line2);
                    int resource_number = input.nextInt();


                    if(resource_number == 5){
                        break;
                    }
                    else{
                        System.out.printf("Wie viele Maschinen sollen zu %s zugewiesen werden?\n", player.resource_names(resource_number));
                        //String line3 = reader.readLine();
                        //int amount = Integer.parseInt(line3);
                        int amount = input.nextInt();

                        if (amount > 0 ){
                            int check_enough_free_machines = player.machine_assignment.get(0) - amount;
                            if(check_enough_free_machines>=0){
                                player.machine_assignment.put(0, player.machine_assignment.get(0) -amount);

                                player.machine_assignment.put(resource_number,player.machine_assignment.get(resource_number) +amount);

                            }
                        }

                    }



                }


                else if(player_action2 == 3){
                    System.out.print("Wo sollen Maschinen freigegeben werden?\n");
                    System.out.printf("1.Getreide\n2.Öl\n3.Metall\n4.Kristall\n5.Abbrechen\n");

                    //String line2 = reader.readLine();
                    //int resource_number = Integer.parseInt(line2);
                    int resource_number = input.nextInt();


                    if(resource_number == 5){
                        break;
                    }
                    else{
                        System.out.printf("Wie viele Maschinen sollen von %s freigegeben werden?\n", player.resource_names(resource_number));
                        //String line4 = reader.readLine();
                        //int amount = Integer.parseInt(line4);
                        int amount = input.nextInt();

                        if (amount > 0 ){
                            int check_enough_machines = player.machine_assignment.get(resource_number) - amount;
                            if(check_enough_machines>=0){
                                player.machine_assignment.put(0, player.machine_assignment.get(0) +amount);
                                player.machine_assignment.put(resource_number,player.machine_assignment.get(resource_number) - amount);

                            }
                        }

                    }
                }


                else if(player_action2 == 4){
                    break;
                }
            }
        }catch (Exception e){
            input.close();
        }

    }
}
