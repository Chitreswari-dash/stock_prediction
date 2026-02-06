package code;
import java.util.*;
public class StockTradingSimulator {
    // 1. Unlimited Transactions (No Fee, No Cooldown)
    public static int maxProfitMultipleTransactions(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;             // Not holding stock
        dp[0][1] = -prices[0];    // Holding stock

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    // 2. With Transaction Fee
    public static int maxProfitWithFee(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    // 3. With Cooldown
    public static int maxProfitWithCooldown(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] sold = new int[n];
        int[] held = new int[n];
        int[] rest = new int[n];
        held[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            held[i] = Math.max(held[i - 1], rest[i - 1] - prices[i]);
            sold[i] = held[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }
        return Math.max(sold[n - 1], rest[n - 1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println("Profit (Multiple Transactions): " + maxProfitMultipleTransactions(prices));
        System.out.println("Profit (With Fee = 3): " + maxProfitWithFee(prices, 3));
        System.out.println("Profit (With Cooldown): " + maxProfitWithCooldown(prices));
    }
}
