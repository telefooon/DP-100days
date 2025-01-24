class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = 1_000_000_007;
        arrLen = Math.min(steps, arrLen);
        int[] dp = new int[arrLen];
        dp[0] = 1;

        for (int step = 1; step <= steps; step++) {
            int[] nextDp = new int[arrLen];
            for (int i = 0; i < arrLen; i++) {
                nextDp[i] = dp[i];
                if (i > 0) {
                    nextDp[i] = (nextDp[i] + dp[i - 1]) % mod;
                }
                if (i < arrLen - 1) {
                    nextDp[i] = (nextDp[i] + dp[i + 1]) % mod;
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }
}
