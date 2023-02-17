import java.util.Arrays;

/**
 * Given an array of strings, find the common prefix.  longest common prefix of “abcdefgh” and “abcefgh” is “ABC”
 */
public class LengthOfCommonPrefix {

    //Approach-1 Char by char matching
    // A Function to find the string having the minimum
    // length and returns that length
    static int findMinLength(String arr[], int n)
    {
        int min = arr[0].length();

        for (int i = 1; i < n; i++)
        {
            if (arr[i].length() < min)
            {
                min = arr[i].length();
            }
        }

        return (min);
    }

    // A Function that returns the longest common prefix
    // from the array of strings
    static String commonPrefix(String arr[], int n)
    {
        int minlen = findMinLength(arr, n);

        String result = ""; // Our resultant string
        char current; // The current character

        for (int i = 0; i < minlen; i++)
        {
            // Current character (must be same
            // in all strings to be a part of
            // result)
            current = arr[0].charAt(i);

            for (int j = 1; j < n; j++)
            {
                if (arr[j].charAt(i) != current)
                {
                    return result;
                }
            }

            // Append to result
            result += (current);
        }

        return (result);
    }


    /**
     * Approach -2 Divide and Conquer
     */
// A Utility Function to find the common prefix between
// strings- str1 and str2
    static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i <= n1 - 1 &&
                j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }

    // A Divide and Conquer based function to find the
    // longest common prefix. This is similar to the
    // merge sort technique
    static String commonPrefix(String arr[], int low, int high) {
        if (low == high) {
            return (arr[low]);
        }

        if (high > low) {
            // Same as (low + high)/2, but avoids overflow for
            // large low and high
            int mid = low + (high - low) / 2;

            String str1 = commonPrefix(arr, low, mid);
            String str2 = commonPrefix(arr, mid + 1, high);

            return (commonPrefixUtil(str1, str2));
        }
        return null;
    }

    /**
     * Approach 3- Using sorting
     * The longest common prefix for an array of strings is the common prefix between 2 most dissimilar strings
     */
    public String longestCommonPrefix(String[] a)
    {
        int size = a.length;

        /* if size is 0, return empty string */
        if (size == 0)
            return "";

        if (size == 1)
            return a[0];

        /* sort the array of strings */
        Arrays.sort(a);

        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size-1].length());

        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;

        String pre = a[0].substring(0, i);
        return pre;
    }
}
