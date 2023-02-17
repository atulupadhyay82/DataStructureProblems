public class Main {
    public static void main(String[] args) {

        System.out.println(max(new int[]{
                1,2,3,3,4,599,-1,-2
        }));
        System.out.println(maxLenSubStr("aaa"));
    }
    public static int max(int A[]){
        int product=1;
        for(int no:A){
            product*=no;
        }
       return (product > 0) ? 1: product<0 ? -1: 0;
    }

    static int maxLenSubStr(String s)
    {
        // If the length of the given string
        // is less than 3
        if (s.length() < 3)
            return s.length();

        int temp = 2;
        int ans = 2;
        for (int i = 2; i < s.length(); i++)
        {

            if (s.charAt(i) != s.charAt(i - 1) ||
                    s.charAt(i) != s.charAt(i - 2))
                temp++;
            else
            {
                ans = (temp >= ans) ? temp : ans;
                temp = 2;
            }
        }
        ans =  (temp >= ans) ? temp : ans;
        return ans;
    }


}