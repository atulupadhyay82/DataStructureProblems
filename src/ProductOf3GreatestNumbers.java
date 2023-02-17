import java.util.Arrays;

/**
 * Given an array, locate the three greatest numbers and print their product.
 */
public class ProductOf3GreatestNumbers {

    /**
     * Approach-1
     * roach 3:
     * Sort the array using some efficient in-place sorting algorithm in ascending order.
     * Return the maximum product of the last three elements of the array and the product of the first two elements and last element.
     */
    static int maxProduct(int arr[], int n) {
        // if size is less than 3, no triplet exists
        if (n < 3) {
            return -1;
        }

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Return the maximum of product of last three
        // elements and product of first two elements
        // and last element
        return Math.max(arr[0] * arr[1] * arr[n - 1],
                arr[n - 1] * arr[n - 2] * arr[n - 3]);
    }

    /**
     * Approach -2
     * Scan the array and compute Maximum, second maximum and third maximum element present in the array.
     * Scan the array and compute Minimum and second minimum element present in the array.
     * Return the maximum product of Maximum, second maximum and third maximum and product of Minimum, second minimum and Maximum element.
     */

// Function to find a maximum product of
// a triplet in array of integers of size n
    static int maxProduct_1(int []arr, int n)
    {

        // If size is less than 3, no triplet exists
        if (n < 3)
            return -1;

        // Initialize Maximum, second maximum
        // and third maximum element
        int maxA = Integer.MIN_VALUE,
                maxB = Integer.MIN_VALUE,
                maxC = Integer.MIN_VALUE;

        // Initialize Minimum and
        // second minimum element
        int minA = Integer.MAX_VALUE,
                minB = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {

            // Update Maximum, second maximum
            // and third maximum element
            if (arr[i] > maxA)
            {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            }

            // Update second maximum and
            // third maximum element
            else if (arr[i] > maxB)
            {
                maxC = maxB;
                maxB = arr[i];
            }

            // Update third maximum element
            else if (arr[i] > maxC)
                maxC = arr[i];

            // Update Minimum and second
            // minimum element
            if (arr[i] < minA)
            {
                minB = minA;
                minA = arr[i];
            }

            // Update second minimum element
            else if(arr[i] < minB)
                minB = arr[i];
        }

        return Math.max(minA * minB * maxA,
                maxA * maxB * maxC);
    }


}

