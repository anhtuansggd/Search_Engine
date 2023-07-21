package search;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author tuan
 */
public interface findStrategy{
    ArrayList<Integer> getResult(String name, ArrayList<String> allInput, Map<String, ArrayList<Integer>> map);
}
