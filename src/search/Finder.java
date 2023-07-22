package search;
import java.util.Map;
import java.util.ArrayList;

/***
 * Finder works as a context reference for any strategy
 ***/
public class Finder{
    protected static findStrategy strategy;

    Finder(findStrategy strategy) {
         Finder.strategy = strategy;
    }
    
    public ArrayList<Integer> find(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map){
        return strategy.getResult(name, allInput, map);
    }
}
