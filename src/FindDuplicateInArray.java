import java.util.HashMap;
import java.util.HashSet;

public class FindDuplicateInArray {

    public static void main(String a[]){
        int array[]=new int[]{4,5,6,3,2,5};
        boolean isDuplicate;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<array.length;i++){
            isDuplicate=set.add(array[i]);
            if(!isDuplicate){
                System.out.println(array[i]);
            }
        }

        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }
            else{
                map.put(array[i],1);
            }
        }
        map.forEach((k,v)->{
            if(v>1){
                System.out.println(k);
            }
        });


    }
}
