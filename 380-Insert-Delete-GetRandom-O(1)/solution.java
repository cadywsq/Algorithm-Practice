public class RandomizedSet {
    // key is the value of integer, value is its index in list
    private final Map<Integer, Integer> dataMap;
    private final List<Integer> dataList;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.dataMap = new HashMap<>();
        this.dataList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!dataMap.containsKey(val)) {
            dataMap.put(val, dataList.size());
            dataList.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dataMap.containsKey(val)) {
            return false;
        }
        // if not removing the last added, swap to-be-removed with the last to fill the gap;
        int index = dataMap.get(val);
        if (index != dataList.size()-1) {
            int lastVal = dataList.get(dataList.size()-1);
            dataList.set(index, lastVal);
            dataMap.put(lastVal, index);
        }
        dataMap.remove(val);
        dataList.remove(dataList.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) Math.random() * dataList.size();
        return dataList.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */