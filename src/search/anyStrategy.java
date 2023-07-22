package search;

import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;

/***
 * anyStrategy finds all input names that can come from the given name
 ***/

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

        return resPosition;
    }
}
