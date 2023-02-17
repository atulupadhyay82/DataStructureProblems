/**
 * Compress a string. Ex: aaabbbcccccddddd, convert it to a3b3c4d4.
 */
public class CompressString {

    /**
     * Pick the first character from the source string.
     * Append the picked character to the destination string.
     * Count the number of subsequent occurrences of the picked character and append the count to the destination string.
     * Pick the next character and repeat steps 2, 3 and 4 if the end of the string is NOT reached.
     * @param str
     */
    static void gen_compressed_str(String str)
    {
        int n = str.length();
        for (int i = 0; i < n; i++) {


            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 &&
                    str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }


            if (count == 1) {
                System.out.print(str.charAt(i) + "1");
            }
            else {
                System.out.print(str.charAt(i));
                System.out.print(count);
            }
        }
    }

}
