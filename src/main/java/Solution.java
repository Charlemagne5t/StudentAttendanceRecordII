public class Solution {
    public int checkRecord(int n) {
        int mod = (int)1e9 + 7;
        Long[][][] memo = new Long[n + 1][2][3];
        return (int)dfs(n, 0, 0, memo) % mod;
    }
    long dfs(int n, int usedA, int LInARow, Long[][][] memo) {
        if(memo[n][usedA][LInARow] != null) {
            return memo[n][usedA][LInARow];
        }
        if(n == 0) {
            return 1;
        }
        int mod = (int)1e9 + 7;
        long resA = 0;
        long resL = 0;
        long resP = dfs(n - 1, usedA, 0, memo) % mod;
        if(LInARow < 2) {
            resL =  dfs(n - 1, usedA, LInARow + 1, memo) % mod;
        }
        if(usedA == 0) {
            resA = dfs(n - 1, 1, 0, memo) % mod;
        }
        memo[n][usedA][LInARow] = (resA + resL + resP) % mod;
        return (resA + resL + resP) % mod;
    }
}