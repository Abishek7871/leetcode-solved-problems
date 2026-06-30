class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        
        // Find the maximum pile size to set the search boundary
        for (int pile : candies) {
            if (pile > high) {
                high = pile;
            }
        }
        
        int ans = 0;
        
        // Binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(candies, k, mid)) {
                ans = mid;       // Track maximum valid configuration
                low = mid + 1;   // Try a larger value
            } else {
                high = mid - 1;  // Try a smaller value
            }
        }
        
        return ans;
    }
    
    // Helper method to check if 'mid' candies per child is possible
    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0;
        for (int pile : candies) {
            count += pile / mid;
            if (count >= k) {
                return true; // Early exit if requirement is satisfied
            }
        }
        return count >= k;
    }
}

