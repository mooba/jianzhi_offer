import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // new 
        Map<Integer, Integer> numToFrequent = new HashMap<>(nums.length);
        for (int num : nums) {
            // if (numToFrequent.get(num) == null) {
            //     numToFrequent.put(num, 1);
            // } else {
            //     numToFrequent.put(num, numToFrequent.get(num) + 1);
            // }

            numToFrequent.merge(num, 1, (v1, v2) -> v1 + v2);
        }



        Queue<Freq> priorityQueue = new PriorityQueue<>((f1, f2) -> f1.freq - f2.freq);
        
        for (Integer key: numToFrequent.keySet()) {
            Integer freqValue = numToFrequent.get(key);
            priorityQueue.add(new Freq(key, freqValue));
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] retNums = new int[k];
        for (int i = 0; i < k; i ++) {
            retNums[i] = priorityQueue.poll().num;
        }
        return retNums;
    }

    static class Freq {
        int num;
        int freq;

        public Freq(int num , int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}
// @lc code=end

