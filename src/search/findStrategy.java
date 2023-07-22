package search;

import java.util.Map;
import java.util.ArrayList;

/***
 * Interface findStrategy defines a common methods for the group of strategies to follow
 ***/

public interface findStrategy{
    ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map);
}
