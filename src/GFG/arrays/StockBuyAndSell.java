package GFG.arrays;

public class StockBuyAndSell {
    static int maxProfit(int[] prices){
        int totalProfit = 0;

        for (int i = 0; i < prices.length -1; i++) {
            if (prices[i+1] > prices[i]){
                totalProfit += prices[i+1] - prices[i];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices));
    }
}
