package com.example.montyhall;

import java.text.DecimalFormat;
import java.util.Random;
public class MontyHallLogic {
    public String run(Integer number) {
        Random rng = new Random();
        String results = "";

        int winsWithChange = 0;
        for (int i = 1; i <= number; i++) {
            int carDoor = rng.nextInt(3);
            int personsDoor = rng.nextInt(3);

            int goatDoor = carDoor;
            while (goatDoor == carDoor || goatDoor == personsDoor) {
                goatDoor = rng.nextInt(3);
            }

            int alternativeDoor = 3 - (personsDoor + goatDoor);

            if (alternativeDoor == carDoor) winsWithChange++;
        }

        int winsWithNoChange = 0;
        for (int i = 1; i <= number; i++) {
            int prize_door = rng.nextInt(3);
            int contestantDoor = rng.nextInt(3);

            if (contestantDoor == prize_door) winsWithNoChange++;
        }


        double formattedPercentWithNoChanges = ((double) winsWithNoChange / number) * 100.0;
        double formattedPercentWithChanges = ((double) winsWithChange / number) * 100.0;




        results += "If player never changes the door:" + "\ntotal wins of " + number + " games played " + ": " + winsWithNoChange +
                "\nPercent win: " + formattedPercentWithNoChanges + "%\n" +
                "\nIf player always changes the door:" + "\ntotal wins of " + number + " games played " + ": " + winsWithChange +
                "\nPercent win: " + formattedPercentWithChanges + "%";

        return results;
    }
}
