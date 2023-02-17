import java.util.Arrays;

/**
 * Given a string S, The task is to remove all the consecutive
 * duplicate characters of the string and return the resultant string.
 * Input: S = “aabccba”
 * Output: abcba
 */
public class RemoveDuplicateFromString {

    //Approach-1
    static void removeDuplicates(char[] S)
    {
        int n = S.length;

        // We don't need to do anything for
        // empty or single character string.
        if (n < 2) {
            return;
        }

        // j is used to store index is result
        // string (or index of current distinct
        // character)
        int j = 0;

        // Traversing string
        for (int i = 1; i < n; i++) {
            // If current character S[i]
            // is different from S[j]
            if (S[j] != S[i]) {
                j++;
                S[j] = S[i];
            }
        }
        System.out.println(Arrays.copyOfRange(S, 0, j + 1));
    }

    /**
     * Approach-2
     * If the string is empty, return.
     * Else compare the adjacent characters of the string. If they are the same then shift the characters
     * one by one to the left. Call recursion on string S
     * If they are not same then call recursion from S+1 string.
     */
    public static String
    removeConsecutiveDuplicates(String input)
    {
        if (input.length() <= 1)
            return input;
        if (input.charAt(0) == input.charAt(1))
            return removeConsecutiveDuplicates(
                    input.substring(1));
        else
            return input.charAt(0)
                    + removeConsecutiveDuplicates(
                    input.substring(1));
    }
    public static void main(String a[]){

    }
}
