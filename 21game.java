class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }

        double[] dp = new double[k + maxPts];
        double windowSum = 0.0;

        for (int i = k; i < k + maxPts; i++) {
            if (i <= n) {
                windowSum += 1;
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            dp[i] = windowSum / maxPts;
            double remove = 0.0;
            if(i + maxPts <= n){
                remove = dp[i + maxPts] == 0 ? 1 : dp[i + maxPts];
            }
            windowSum += dp[i] - remove;
        }

        return dp[0];
    }
}
