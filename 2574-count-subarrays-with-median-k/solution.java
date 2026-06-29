import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> balanceCounts = new HashMap<>();
        balanceCounts.put(0, 1); 
        
        int runningBalance = 0;
        int totalSubarrays = 0;
        boolean foundK = false;

        for (int num : nums) {
           
            if (num < k) {
                runningBalance--;
            } else if (num > k) {
                runningBalance++;
            } else {
                foundK = true;
            }

            if (!foundK) {
                balanceCounts.put(runningBalance, balanceCounts.getOrDefault(runningBalance, 0) + 1);
            } else {
                totalSubarrays += balanceCounts.getOrDefault(runningBalance, 0);
                
                totalSubarrays += balanceCounts.getOrDefault(runningBalance - 1, 0);
            }
        }

        return totalSubarrays;
    }
}

