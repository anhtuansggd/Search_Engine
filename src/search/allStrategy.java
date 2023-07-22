package search;

import java.util.Map;
import java.util.ArrayList;

/***
 * allStrategy finds whether name is included in any names of allInput
 ***/

public class allStrategy implements findStrategy{
    @Override
    public ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map) {
        ArrayList<Integer> resPosition = new ArrayList<>();
        int counter = -1;

        for(String eachName : allInput){
            counter++;
            if(eachName.toLowerCase().contains(name.toLowerCase())){
                resPosition.add(counter);
            }
        }

        return resPosition;
    }
}
