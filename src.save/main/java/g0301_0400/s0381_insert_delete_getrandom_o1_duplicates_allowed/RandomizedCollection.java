package g0301_0400.s0381_insert_delete_getrandom_o1_duplicates_allowed;

// #Hard #Array #Hash_Table #Math #Design #Randomized
// #2022_03_18_Time_26_ms_(100.00%)_Space_92.4_MB_(81.64%)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

@SuppressWarnings({"java:S3824", "java:S2245"})
public class RandomizedCollection {
    private HashMap<Integer, HashSet<Integer>> hashMap;
    private int[] arr;
    private int size;
    private Random rand;

    public RandomizedCollection() {
        hashMap = new HashMap<>();
        size = 0;
        arr = new int[200000];
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean exists = true;
        if (!hashMap.containsKey(val)) {
            exists = false;
            hashMap.put(val, new HashSet<>());
        }
        hashMap.get(val).add(size);
        arr[size] = val;
        size++;
        return !exists;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }
        int idx = hashMap.get(val).iterator().next();
        int lastVal = arr[size - 1];
        if (lastVal != val) {
            hashMap.get(lastVal).add(idx);
            hashMap.get(val).remove(idx);
        }
        hashMap.get(lastVal).remove(size - 1);
        arr[idx] = lastVal;
        if (hashMap.get(val).isEmpty()) {
            hashMap.remove(val);
        }
        size--;
        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(size);
        return arr[idx];
    }
}
