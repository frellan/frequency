import java.util.*;

class Frequency {
	static List<Comparable> frequency(List<Comparable> list) {
        List<Comparable> result = new ArrayList<>();
    	Map<Comparable, Integer> map = new HashMap<>();
    	for (Comparable c : list) {
    	    if (map.containsKey(c)) {
    	        int count = map.get(c);
    	        map.replace(c, ++count);
            } else {
    	        map.put(c, 1);
            }
            if (!result.contains(c)) {
    	        result.add(c);
            }
        }
        result.sort((o1, o2) -> map.get(o2) - map.get(o1));
    	return result;
    }
}
