package ohrman.max;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Map<Integer,Location> locations = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String,Integer> exits = locations.get(loc).getExits();

            System.out.print("Available exits: ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String[] input = scanner.nextLine().split(" ");
            String direction = null;

            for (String i : input) {
                if (i.equalsIgnoreCase("north") || i.equalsIgnoreCase("n")) {
                        direction = "N";
                    } else if (i.equalsIgnoreCase("south") || i.equalsIgnoreCase("s")) {
                        direction = "S";
                    } else if (i.equalsIgnoreCase("east") || i.equalsIgnoreCase("e")) {
                        direction = "E";
                    } else if (i.equalsIgnoreCase("west") || i.equalsIgnoreCase("w")) {
                        direction = "W";
                    } else if (i.equalsIgnoreCase("quit") || i.equalsIgnoreCase("q")) {
                    direction = "Q";
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }


    }
}
