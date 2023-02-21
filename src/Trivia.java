import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;


public class Trivia {
    static List<String> triviaQuestion = new ArrayList<>(), triviaAnswer=new ArrayList<>();
    static{
        triviaQuestion.add("Whats your name");
        triviaQuestion.add("where do you live");
        triviaQuestion.add("what do you do");
        triviaQuestion.add("how much you earn");

        triviaAnswer.add("Ram");
        triviaAnswer.add("Aligarh");
        triviaAnswer.add("retired");
        triviaAnswer.add("34000");
    }

    public static String getQuestion(int i){
        return triviaQuestion.get(i);
    }
    public static String getAnswer(int i){
        return triviaAnswer.get(i);
    }

    public static int size(){
        return triviaQuestion.size();
    }
    private static List<Integer> getRandomNo(int min, int numQuestions) {
        Set<Integer> generated = new LinkedHashSet<>();
        while (generated.size() < numQuestions)
        {
            Integer num = ThreadLocalRandom.current().nextInt(min, numQuestions + 1);
            // As we're adding to a set, this will automatically do a containment check
            generated.add(num);

        }
        System.out.println(generated);
        List<Integer> randomNo = new ArrayList<>();
        randomNo.addAll(generated);
        Collections.shuffle(randomNo);
        System.out.println(randomNo);
        return randomNo;
    }

    public static void main(String a[]){
        List<Integer> randomNo=getRandomNo(0,size());
        int questionCount=0,index=0;
        int numQuestion=size();
        boolean next=false, correct=false, start=true;
        Scanner sc= new Scanner(System.in);
        while(true){

            if(questionCount == numQuestion) {
                System.out.println("Game ends!!. Play Again");
                break;
            }
            if(next == true || correct ==true || start ==true){
                index= randomNo.get(questionCount);
                System.out.println(index);
                System.out.println(getQuestion(index));
                correct=false;
                next=false;
                questionCount++;
            }
            String input=sc.nextLine();
            start=false;

            if(input.equalsIgnoreCase(getAnswer(index))){
                System.out.println("Correct");
                correct=true;
            } else if (!input.equalsIgnoreCase(getAnswer(index)) && input.equalsIgnoreCase("next")){
                next=true;
            }else if (!input.equalsIgnoreCase(getAnswer(index)) && input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing triva!");
                break;
            }else if(!input.equalsIgnoreCase(getAnswer(index))) {
                System.out.println("Wrong!");
                correct=false;
                next=false;
            }
        }
    }
}
