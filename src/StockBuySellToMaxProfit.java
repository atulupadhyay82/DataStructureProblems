/**
 * The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying
 * and selling on those days. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 *
 * Examples:
 *
 * Input: arr[] = {100, 180, 260, 310, 40, 535, 695}
 * Output: 865
 * Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
 *                        Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
 *                        Maximum Profit  = 210 + 655 = 865
 */
public class StockBuySellToMaxProfit {

    /**
     * Approach-1
     * In this approach, we just need to find the next greater element and subtract it from the current
     * element so that the difference keeps increasing until we reach a minimum.
     * If the sequence is a decreasing sequence, so the maximum profit possible is 0.
     *
     * Follow the steps below to solve the problem:
     *
     * maxProfit = 0
     * if price[i] > price[i – 1]
     * maxProfit = maxProfit + price[i] – price[i – 1]
     * Below is the implementation of the above approach:
     */

    static int maxProfit(int prices[], int size)
    {

        // maxProfit adds up the difference between
        // adjacent elements if they are in increasing order
        int maxProfit = 0;

        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }

}
