package leetcode.Blind75.SlidingWindow;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(getBestTime(new int[]{7,1,5,2,6,4}));
        System.out.println(getBestTime(new int[]{7,6,4,3,1}));
        System.out.println(getBestTime(new int[]{7,6,4,3,1,7,1,5,2,6,4}));
    }

    public static int getBestTime(int[] prices){
        int maxProfit = 0;
        int left = 0;
        int leftLowPrice = Integer.MAX_VALUE;

        for(int right = 1;right<prices.length;right++){
            if(prices[right]-prices[left]>maxProfit){
                maxProfit = prices[right] - prices[left];
            }else if(prices[right]<leftLowPrice){
                left = right;
            }
            leftLowPrice = prices[left];
        }

        return maxProfit;
    }
}
