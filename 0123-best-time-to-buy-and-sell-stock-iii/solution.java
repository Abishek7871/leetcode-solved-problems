class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 1, prices, 2, dp);
    }

    private int helper(int idx, int canBuy, int[] prices, int transactionsLeft, int[][][] dp){
        if(idx == prices.length) return 0;
        if(transactionsLeft == 0) return 0;

        if(dp[idx][canBuy][transactionsLeft] != -1) return dp[idx][canBuy][transactionsLeft];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1, 0, prices, transactionsLeft, dp), 0 + helper(idx+1, 1, prices, transactionsLeft, dp));
        }
        else{
            profit = Math.max(prices[idx] + helper(idx+1, 1, prices, transactionsLeft-1, dp), 0 + helper(idx+1, 0, prices, transactionsLeft, dp));
        }

        return dp[idx][canBuy][transactionsLeft] = profit;
    }
}
