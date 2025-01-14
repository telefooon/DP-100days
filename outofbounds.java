class Solution {
    private static final int MOD = 1_000_000_007;
    private int ROWS, COLS;
    private Map<String, Integer> cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        ROWS = m;
        COLS = n;
        cache = new HashMap<>();
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int r, int c, int moves) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) {
            return 1;
        }
        if (moves == 0) {
            return 0;
        }
        String key = r + "," + c + "," + moves;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        long result = 0;
        result = (result + dfs(r + 1, c, moves - 1)) % MOD;
        result = (result + dfs(r - 1, c, moves - 1)) % MOD;
        result = (result + dfs(r, c + 1, moves - 1)) % MOD;
        result = (result + dfs(r, c - 1, moves - 1)) % MOD;

        cache.put(key, (int) result);
        return (int) result;
    }
}