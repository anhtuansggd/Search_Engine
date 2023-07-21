package search;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

import search.findStrategy;
import search.Finder;
import search.allStrategy;
import search.anyStrategy;
import search.noneStrategy;

/*
 * javac --class-path ./search/ search/*.java
 * java -classpath ./ search.Main --data ./search/tests.txt
 * */



public class Main {
    
     
    
    public static void find(String name, ArrayList<String> li, Map<String, ArrayList<Integer>> map){
        ArrayList<Integer> resPosition = new ArrayList<>();
        int counter = 0;
        for(var entry : map.entrySet()){
            if(entry.getKey().equalsIgnoreCase(name)){
                resPosition.addAll(entry.getValue());
                counter++;
            }
        }
        if(counter!=0){
            System.out.println(counter+" persons found:");
            for(int s : resPosition){
                System.out.println(li.toArray()[s]);
            }
        }else{
            System.out.println("No matching people found.");
        }

    }
    
    


    public static void main(String[] args) throws IOException {
        File file = null;
        for(int i=0; i< args.length; i++){
            if(args[i].equals("--data")){
                String fileName = args[i+1];
                file = new File(fileName);
            }
        }
        Scanner scFile = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the number of people:");
        //int a = sc.nextInt();

        //System.out.println("Enter all people:");
//        List<String> li = new ArrayList<>();
//
//        while(scFile.hasNextLine()){
//            String inpt = scFile.nextLine();
//            li.add(inpt);
//        }

        //New Data Structure applied
        ArrayList<String> allInput = new ArrayList<>();
        Map<String, ArrayList<Integer>> Inverted_Index = new LinkedHashMap<>();
        int counter = -1;
        //IF LOWER CASE PROBLEM FIX HERE
        while(scFile.hasNextLine()) {
            String inpt = scFile.nextLine();
            allInput.add(inpt);
            counter++;
            String ArrInput[] = inpt.split("\\s+");
            for(String s:ArrInput) {
                ArrayList<Integer> temp = Inverted_Index.get(s.toLowerCase());
                if(temp == null) {
                    temp = new ArrayList<>(List.of(counter));
                    Inverted_Index.put(s.toLowerCase(), temp);
                } else {
                    temp.add(counter);
                    System.out.println("AddStage");
                }
            }

        }
        for(var entry : Inverted_Index.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //



        System.out.println(
                "\n=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit"
        );
        int userNum = sc.nextInt();
        while(userNum!=0){
            if(userNum==1){
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                sc.nextLine();
                String userStrategy = sc.nextLine();
                ///newest
                Finder finder = null;
                switch(userStrategy){
                    case "ALL": 
                        finder = new Finder(new allStrategy());
                        break;
                    case "ANY": 
                        finder = new Finder(new anyStrategy());
                        break;
                    case "NONE":
                        finder = new Finder(new noneStrategy());
                } 
                ///
                System.out.println("\nEnter a name or email to search all suitable people.");
                //sc.nextLine(); //?
                String inptName = sc.nextLine();
                //finder.getResults()
                ArrayList<Integer> nameResult = finder.find(inptName, allInput, Inverted_Index);
                System.out.println(nameResult.size()+" persons found:");
                for(int i=0; i<allInput.size(); i++){
                    for(int j:nameResult){
                        if(i==j){
                            System.out.println(allInput.get(i));
                        }
                    }
                }
                
                
               
                
                
                //
//                for(String s:li){
//                    if(s.toLowerCase().contains(inptName.toLowerCase().trim())){
//                        System.out.println(s);
//                    }
//                }
                //find(inptName, allInput, Inverted_Index);
            }else if(userNum==2){
                System.out.println("=== List of people ===");
                for(String s:allInput){
                    System.out.println(s);
                }
            }else{
                System.out.println("\nIncorrect option! Try again.");
            }
            System.out.println(
                    "\n=== Menu ===\n" +
                            "1. Find a person\n" +
                            "2. Print all people\n" +
                            "0. Exit"
            );
            userNum =sc.nextInt();
        }
        scFile.close();
        System.out.println("Bye!");


    }


}

//public interface findStrategy{
//    ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map);
//}

//public class Finder{
//    protected static findStrategy strategy;
//
//    Finder(findStrategy strategy) {
//         Finder.strategy = strategy;
//    }
//    
//    public ArrayList<Integer> find(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map){
//        return strategy.getResult(name, allInput, map);
//    }
//}

//public class allStrategy implements findStrategy{
//
//    @Override
//    public ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map) {
//        ArrayList<Integer> resPosition = new ArrayList<>();
//        
//        return resPosition;
//    }
//    
//}

//public class anyStrategy implements findStrategy{
//
//    @Override
//    public ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> mapP) {
//        //TEMP
//        ArrayList<Integer> resPosition = new ArrayList<>();
//        
//        return resPosition;
//    
//    }
    
   
    
    
//}

// class noneStrategy implements findStrategy{

//     @Override
//     public ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map) {
//         ArrayList<String> nameToDifference = new ArrayList<>(Arrays.asList(name.split("\\s+")));
//         ArrayList<Integer> resPosition = new ArrayList<>();
//         int counter = 0;
//         for(String eachName : nameToDifference){
//             if(!map.containsKey(eachName)){
//                 ArrayList<Integer> values = map.get(eachName);
//                 resPosition.addAll(values);
//             }
//         }
//         return resPosition;
  
        
// //        ArrayList<Integer> resPosition = new ArrayList<>();
// //        int counter = 0;
// //        for(var entry : map.entrySet()){
// //            if(entry.getKey().equalsIgnoreCase(name)){
// //                resPosition.addAll(entry.getValue());
// //                counter++;
// //            }
// //        }
// //        if(counter!=0){
// //            System.out.println(counter+" persons found:");
// //            for(int s : resPosition){
// //                System.out.println(allInput.toArray()[s]);
// //            }
// //        }else{
// //            System.out.println("No matching people found.");
// //        }

//     }
    
// }
