import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
 *
 * Examples :
 *
 * Input: arr[] = {0, -1, 2, -3, 1}
 * Output: (0 -1 1), (2 -3 1)
 * Explanation: The triplets with zero sum are 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
 */
public class TripletSumEqTo0 {

    /**
     * Approach -1
     * Follow the steps below to implement the idea:
     *
     * Create a Hashmap to store a key-value pair.
     * Run a nested loop with two loops, the outer loop from 0 to n-2 and the inner loop from i+1 to n-1
     * Check if the sum of ith and jth element multiplied with -1 is present in the Hashmap or not
     * If the element is present in the Hashmap, print the triplet else insert the j’th element in the Hashmap.
     * Time Complexity: O(n2), Since two nested loops are required, so the time complexity is O(n2).
     * Auxiliary Space: O(n), Since a Hashmap is required, so the space complexity is linear.
     */
    // function to print triplets with 0 sum
    static void findTriplets(int arr[], int n) {
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x,
                            arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[j]);
                }
            }
        }
    }

    /**
     * Approach 2
     * Sort the array in ascending order.
     * Traverse the array from start to end.
     * For every index i, create two variables l = i + 1 and r = n – 1
     * Run a loop until l is less than r if the sum of array[i], array[l] and array[r] is
     * equal to zero then print the triplet and break the loop
     * If the sum is less than zero then increment the value of l,
     * by increasing the value of l the sum will increase as the array is sorted, so array[l+1] > array [l]
     * If the sum is greater than zero then decrement the value of r,
     * by decreasing the value of r the sum will decrease as the array is sorted, so array[r-1] < array [r].
     * Time Complexity: O(n2), Only two nested loops are required, so the time complexity is O(n2).
     * Auxiliary Space: O(1), no extra space is required, so the space complexity is constant.
     */
    static void findTriplets_2(int arr[], int n)
    {
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.println(arr[r] + " ");

                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero then
                    // decrement in right side
                else
                    r--;
            }
        }

        if (found == false)
            System.out.println(" No Triplet Found");
    }
}
