import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Move the last element to the index of the element to be removed
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element from the list and the map
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());

        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */