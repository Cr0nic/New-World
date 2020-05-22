package com.company;
import java.util.*;
import java.io.BufferedReader;

public class Beenden {
    public static void execution(Player player){
        //BufferedReader reader = InputLibrary.getReader();
        int[] herstellung = {10,5,1,2};
        Scanner input = InputLibrary.getReader();


        //CHECK GENUG GETREIDE FÜR SIEDLER
        int starving_siedler = player.resources.get(1) -player.siedler;
        if(starving_siedler<0){
            player.siedler = player.siedler +starving_siedler;
            player.resources.put(1, player.resources.get(1)+ player.siedler);


        }else{
            player.resources.put(1, player.resources.get(1)- player.siedler);

        }


        //CHECK GENUG SIEDLER MASCHINEN
        int machine_count = player.hashmap_add()- player.machine_assignment.get(0);
        int available_machines = 0;
        int not_available_machines = player.siedler - machine_count;
        if(not_available_machines<0){
            available_machines = machine_count - not_available_machines;
        }else{
            available_machines = machine_count;
        }

        //CHECK wie viele Maschinen öl bekommen können
        int x = player.resources.get(2) -available_machines ;
        if(x<0){
            available_machines = available_machines-x;
            //CHECK DAS GENUG ÖL FÜR DIE MASCHINEN
            if(player.resources.get(2) < available_machines){

            }else{
                player.resources.put(2, player.resources.get(2)- available_machines);
            }
        }else{
            player.resources.put(2, player.resources.get(2)- available_machines);
        }

        //PRODUZIEREN DER RESSOURCEN
        /*
        for (int i = 0; i < available_machines;i++){
            if(player.machine_assignment.get(i+1) != 0){
                player.resources.put(i+1,(herstellung[i] * player.machine_assignment.get(i+1)) +player.resources.get(i+1));
                //available_machines =player.machine_assignment.get(i+1) - available_machines;
            }
        */
        int i = 1;
        while(true){

            if(player.machine_assignment.get(i) != 0){
                player.resources.put(i,(herstellung[i-1] * player.machine_assignment.get(i)) +player.resources.get(i));
                int test = available_machines -player.machine_assignment.get(i);
                //System.out.println(">>>>>>>>>>>>>>>>>>>"+player.machine_assignment.get(i));
                //System.out.println(">>>>>>>>>>>>>>>>>>>"+i);
                if(test > 0){
                    available_machines =test;
                }else if (test <=0){

                    break;
                }
            }
            i++;
        }

    }
}
