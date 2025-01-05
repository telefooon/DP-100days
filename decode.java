import java.util.*;

public class decode{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }
            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
