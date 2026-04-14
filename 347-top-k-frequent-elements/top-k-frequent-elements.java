import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Step 1: Frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Max Heap (based on frequency)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]   // sort by frequency (descending)
        );

        // Step 3: Push {frequency, number}
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }

        // Step 4: Get top k elements
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }

        return result;
    }
}