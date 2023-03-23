public class CommonMethodUsingGeneric {

    public static <T> T add(T param1 ,T param2){
        if(param1 instanceof String && param2 instanceof String){
            return (T) (param1.toString()+ param2.toString());
        }else if(param1 instanceof Integer && param2 instanceof Integer){
            return (T) (((Integer)((Integer)param1+ (Integer) param2)));
        }else if(param1 instanceof Float && param2 instanceof Float){
            return (T) (((Float)((Float)param1+ (Float) param2)));
        }else{
            throw new IllegalArgumentException("Cannot add parameters of different datatype: "+param1.getClass()+" and "+ param2.getClass());
        }

    }

    public static void main(String a[]){
        int sumInt= CommonMethodUsingGeneric.add(10,15);
        float sumFloat=CommonMethodUsingGeneric.add(10.4f, 12.5f);
        String sumString= CommonMethodUsingGeneric.add("Abc","Def");
        System.out.println(sumInt);
        System.out.println(sumFloat);
        System.out.println(sumString);

    }
}
