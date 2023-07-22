package search;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * noneStrategy finds names that are different from given name
 */
class noneStrategy implements findStrategy{
    @Override
    public ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map) {
        ArrayList<String> nameToDifference = new ArrayList<>(Arrays.asList(name.split("\\s+")));
        ArrayList<Integer> positionToDifference = new ArrayList<>();

        int counter = 0;
        for(String eachName : nameToDifference){
            if(map.containsKey(eachName.toLowerCase())){
                ArrayList<Integer> values = map.get(eachName.toLowerCase());
                positionToDifference.addAll(values);
            }
        }

        ArrayList<Integer> resPosition = new ArrayList<>();
        for(int i=0; i<allInput.size(); i++){
            if(!positionToDifference.contains(i)){
                resPosition.add(i);
            }
        }

        return resPosition;
    }

    
    
}
