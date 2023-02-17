/**
 * Given string str, the task is to write Java Program check whether the given string is a pangram or not.
 * A string is a pangram string if it contains all the character of the alphabets ignoring the case of the alphabets
 */
public class StringIsPangram {
   static int size = 26;
    // Function to check if ch is a letter
    static boolean isLetter(char ch)
    {
        if (!Character.isLetter(ch))
            return false;

        return true;
    }

    // Function to check if a string
    // contains all the letters from
    // a to z
    static boolean allLetter(String str,
                             int len)
    {
        // Convert the given string
        // into lowercase
        str = str.toLowerCase();

        // Create a frequency array to
        // mark the present letters
        boolean[] present = new boolean[size];

        // Traverse for each character
        // of the string
        for (int i = 0; i < len; i++) {

            // If the current character
            // is a letter
            if (isLetter(str.charAt(i))) {

                // Mark current letter as present
                int letter = str.charAt(i) - 'a';
                present[letter] = true;
            }
        }

        // Traverse for every letter
        // from a to z
        for (int i = 0; i < size; i++) {

            // If the current character
            // is not present in string
            // then return false,
            // otherwise return true
            if (!present[i])
                return false;
        }
        return true;
    }

    /**
     *   Approach-2
     *     // Function to check if a string
     *     // contains all the letters from
     *     // a to z (ignoring case)
      */

    public static void allLetter(String str)
    {
        // Converting the given string
        // into lowercase
        str = str.toLowerCase();

        boolean allLetterPresent = true;

        // Loop over each character itself
        for (char ch = 'a'; ch <= 'z'; ch++) {

            // Check if the string does not
            // contains all the letters
            if (!str.contains(String.valueOf(ch))) {
                allLetterPresent = false;
                break;
            }
        }

        // Check if all letter present then
        // print "Yes", else print "No"
        if (allLetterPresent)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
