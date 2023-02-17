import java.util.HashMap;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times (LeetCode Majority Element II).
 * Input : [10, 10, 20, 30, 10, 10]
 * Output : 10
 * 10 occurs 4 times which is more than 6/3.
 */
public class ElementAppearMoreThanNby3 {

    private static void findMajority(int[] arr)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int flag=0;
        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]) +1;
                if (count > arr.length /3) {
                    System.out.print(arr[i]+" ");
                    flag=1;
                } else
                    map.put(arr[i], count);

            }
            else
                map.put(arr[i],1);
        }
        if(flag==0)
            System.out.println(" No Majority element");
    }



}
