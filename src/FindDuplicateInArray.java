import java.util.*;

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
        // Returns Set view

        //Approach -1 : traversing the map
        map.forEach((k,v)->{
            if(v>1){
                System.out.println(k);
            }
        });

        //Approach -2 : traversing the map
        Set<Map.Entry<Integer, Integer>> st = map.entrySet();

        for (Map.Entry<Integer, Integer> me:st)
        {
            System.out.print(me.getKey()+":"); System.out.println(me.getValue());
        }
        Iterator hmIterator = map.entrySet().iterator();

        //Approach -3 : traversing the map
        // Iterate through the hashmap
        // and add some bonus marks for every student System.out.println("HashMap after adding bonus marks:");

        while (hmIterator.hasNext()) {

            Map.Entry mapElement = (Map.Entry)hmIterator.next(); int marks = ((int)mapElement.getValue() + 10);
            System.out.println(mapElement.getKey() + " : " + marks);
        }



    }
}
