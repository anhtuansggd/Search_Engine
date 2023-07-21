package search;
import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;
/**
 * DONE
 * @author tuan
 */
public class anyStrategy implements findStrategy{


    @Override
    public ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map) {

        ArrayList<String> nameToDifference = new ArrayList<>(Arrays.asList(name.split("\\s+")));
        ArrayList<Integer> resPosition = new ArrayList<>();
        int counter = 0;
        for(String eachName : nameToDifference){
            if(map.containsKey(eachName.toLowerCase())){
                ArrayList<Integer> values = map.get(eachName.toLowerCase());
                resPosition.addAll(values);
            }
        }
        System.out.println(resPosition.size());
        System.out.println("anyStrage");
        return resPosition;


//        ArrayList<Integer> resPosition = new ArrayList<>();
//        int counter = 0;
//        for(var entry : map.entrySet()){
//            if(entry.getKey().equalsIgnoreCase(name)){
//                resPosition.addAll(entry.getValue());
//                counter++;
//            }
//        }
//        if(counter!=0){
//            System.out.println(counter+" persons found:");
//            for(int s : resPosition){
//                System.out.println(allInput.toArray()[s]);
//            }
//        }else{
//            System.out.println("No matching people found.");
//        }

    }


}
