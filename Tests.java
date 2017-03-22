import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tests {

    private static final int NBR_TESTS = 200;
    private static int failed = 0;

    public static void main(String[] args) {
        for (int i = 0; i < NBR_TESTS; i++) {
            List<Comparable> list = getTestList();
            List<Comparable> result = Frequency.frequency(list);
            if (!testOrder(list, result) || !testExisting(list, result))
                failed++;
        }
        System.out.println("Ran " + NBR_TESTS + " tests.");
        if (failed == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(failed + " tests failed!");
        }
    }

    private static boolean testOrder(List<Comparable> original, List<Comparable> result) {
        for (int i = 0; i < result.size() - 1; i++) {
            int count = Collections.frequency(original, result.get(i));
            int nextCount = Collections.frequency(original, result.get(i+1));
            if (count < nextCount)
                return false;
        }
        return true;
    }

    private static boolean testExisting(List<Comparable> original, List<Comparable> result) {
        for (Comparable c : result) {
            if (!original.contains(c))
                return false;
        }
        return true;
    }

    private static List<Comparable> getTestList() {
        List<Comparable> list = new ArrayList<>();
        char[] test = {'A', 'B', 'C', 'D'};
        for (char c : test) {
            for (int i = 0; i < (int)(Math.random() * 20); i++) {
                list.add(c);
            }
        }
        Collections.shuffle(list);
        return list;
    }
}
