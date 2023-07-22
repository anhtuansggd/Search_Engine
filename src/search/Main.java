package search;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/*
 * javac --class-path ./search/ search/*.java
 * java -classpath ./ search.Main --data ./search/tests.txt
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        /***
         * Command line arguements passes the direction of input file if it reads "--data"
         ***/
        File file = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                String fileName = args[i + 1];
                file = new File(fileName);
            }
        }
        Scanner scFile = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        /***
         * Inverted Index data structure implemented by LinkedHashMap for fast retrival based on input order
         * allInput for storing all names
         ***/
        ArrayList <String> allInput = new ArrayList < > ();
        Map < String, ArrayList<Integer> > Inverted_Index = new LinkedHashMap < > ();
        int counter = -1;
        while (scFile.hasNextLine()) {
            String inpt = scFile.nextLine();
            allInput.add(inpt);
            counter++;
            String ArrInput[] = inpt.split("\\s+");
            for (String s: ArrInput) {
                ArrayList <Integer> temp = Inverted_Index.get( s.toLowerCase() );
                if (temp == null) {
                    temp = new ArrayList<>( List.of(counter) );
                    Inverted_Index.put(s.toLowerCase(), temp);
                } else {
                    temp.add(counter);
                }
            }
        }

        /***
         * User Interface
         ***/
        System.out.println(
                "\n=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit\n"
        );
        int userNum = sc.nextInt();
        while (userNum != 0) {
            if (userNum == 1) {
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                sc.nextLine();
                String userStrategy = sc.nextLine();

                /***
                 * Strategy pattern used for 3 find strategies: ALL, ANY, NONE
                 ***/
                Finder finder = null;
                switch (userStrategy) {
                    case "ALL":
                        finder = new Finder(new allStrategy());
                        break;
                    case "ANY":
                        finder = new Finder(new anyStrategy());
                        break;
                    case "NONE":
                        finder = new Finder(new noneStrategy());
                }

                System.out.println("\nEnter a name or email to search all suitable people.");
                String inptName = sc.nextLine();

                /***
                 * nameResult returns indexes to retrive suitable result name from allInput
                 ***/
                ArrayList <Integer> nameResult = finder.find(inptName, allInput, Inverted_Index);
                System.out.println(nameResult.size() + " persons found:");
                for (int i = 0; i < allInput.size(); i++) {
                    for (int j: nameResult) {
                        if (i == j) {
                            System.out.println(allInput.get(i));
                        }
                    }
                }
            } else if (userNum == 2) {
                System.out.println("=== List of people ===");
                for (String s: allInput) {
                    System.out.println(s);
                }
            } else {
                System.out.println("\nIncorrect option! Try again.");
            }
            System.out.println(
                    "\n=== Menu ===\n" +
                            "1. Find a person\n" +
                            "2. Print all people\n" +
                            "0. Exit\n"
            );
            userNum = sc.nextInt();
        }
        scFile.close();
        System.out.println("Bye!");
    }
}