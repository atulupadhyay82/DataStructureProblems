import java.util.Arrays;

/**
 * n anagram of a string is another string that contains the same characters,
 * only the order of characters can be different. For example, “abcd” and “dabc” are an anagram of each other.
 */
public class StringIsAnagram {

    /**
     * Approach-1
     * Sort both strings.
     * Compare the sorted strings:
     * If they are equal return True.
     * Else return False.
     * Time Complexity: O(N * logN), For sorting.
     * Auxiliary Space: O(1) as it is using constant extra space
     */

    /* function to check whether two strings are
    anagram of each other */
    static boolean areAnagram(char[] str1, char[] str2)
    {
        // Get lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    /**
     * Approach -2
     * that the characters are stored using 8 bit and there can be 256 possible characters.
     *
     * So count the frequency of the characters and if the frequency of characters in both strings are the same,
     * they are anagram of each other.
     * Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
     * Iterate through every character of both strings and increment the count of characters in the corresponding count arrays.
     * Compare count arrays. If both count arrays are the same, then return true else return false.
     */

    /* function to check whether two strings
    are anagram of each other */
    static boolean areAnagram_2(char str1[], char str2[])
    {
        int NO_OF_CHARS = 256;
        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;

        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }

}
