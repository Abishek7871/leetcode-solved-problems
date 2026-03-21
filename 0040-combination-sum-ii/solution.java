import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        // Sort to handle duplicates and enable pruning
        Arrays.sort(candidates);
        
        dfs(0, target, candidates, new ArrayList<>(), output);
        return output;
    }

    private void dfs(int startIdx, int remain, int[] candidates, List<Integer> subset, List<List<Integer>> output) {
        if (remain == 0) {
            // Add a copy of the current subset
            output.add(new ArrayList<>(subset));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            // Pruning: if current element is larger than remaining target, break the loop
            if (candidates[i] > remain) {
                break;
            }
            
            // Skip duplicates at the same recursion level
            if (i > startIdx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Move: add element to current subset
            subset.add(candidates[i]);
            
            // Recursion: move to the next index (i + 1) to ensure each element is used once
            dfs(i + 1, remain - candidates[i], candidates, subset, output);
            
            // Undo Move (Backtrack)
            subset.remove(subset.size() - 1);
        }
    }
}
