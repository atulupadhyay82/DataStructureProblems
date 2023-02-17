import java.util.Vector;

/**
 * Given a variety of coin types defining a currency system, find the
 * minimum number of coins required to express a given amount of money. Assume an infinite supply of coins of every type.
 */
public class MinNoOfCoins {

    /**
     * Approach-1
     * Sort the array of coins in decreasing order.
     * Initialize ans vector as empty.
     * Find the largest denomination that is smaller than remaining amount and while it is smaller than the remaining amount:
     * Add found denomination to ans. Subtract value of found denomination from amount.
     * If amount becomes 0, then print ans.
     */

    // All denominations of Indian Currency
    static int deno[] = {1, 2, 5, 10, 20,
            50, 100, 500, 1000};
    static int n = deno.length;

    static void findMin(int V)
    {
        // Initialize result
        Vector<Integer> ans = new Vector<>();

        // Traverse through all denomination
        for (int i = n - 1; i >= 0; i--)
        {
            // Find denominations
            while (V >= deno[i])
            {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }

        // Print result
        for (int i = 0; i < ans.size(); i++)
        {
            System.out.print(
                    " " + ans.elementAt(i));
        }
    }

    /**
     * Approach-2
     * Declare a vector that store the coins.
     *  while n is greater than 0 iterate through greater to smaller coins:
     * if n is greater than equal to 2000 than push 2000 into the vector and decrement its value from n.
     * else if n is greater than equal to 500 than push 500 into the vector and decrement its value from n.
     * And so on till the last coin using ladder if else.
     *  return the vector/array
     */
    static Vector<Integer> findMin_2(int n){
        // initialize vector to store the coins
        Vector<Integer> vec = new Vector<>();
        // iterate till n>0 and check condition according to the
        // greatest coin possible
        while (n > 0) {
            if (n >= 2000) {
                vec.addElement(2000);
                n -= 2000;
            }
            else if (n >= 500) {
                vec.addElement(500);
                n -= 500;
            }
            else if (n >= 200) {
                vec.addElement(200);
                n -= 200;
            }
            else if (n >= 100) {
                vec.addElement(100);
                n -= 100;
            }
            else if (n >= 50) {
                vec.addElement(50);
                n -= 50;
            }
            else if (n >= 20) {
                vec.addElement(20);
                n -= 20;
            }
            else if (n >= 10) {
                vec.addElement(10);
                n -= 10;
            }
            else if (n >= 5) {
                vec.addElement(5);
                n -= 5;
            }
            else if (n >= 2) {
                vec.addElement(2);
                n -= 2;
            }
            else if (n >= 1) {
                vec.addElement(1);
                n -= 1;
            }
        }
        // return the ans that stores in the vector
        return vec;
    }

}
