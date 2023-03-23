import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractStringUsingRE {

    public static List<String> extractWords(String sentence){

        //Regular expression to match words
        Pattern pattern= Pattern.compile("\\b\\w+\\b");
        Matcher matcher= pattern.matcher(sentence);

        //List to store the extract words
        List<String> words= new ArrayList<>();

        //Iterate through matches and add to list
        while(matcher.find()){
            words.add(matcher.group().toLowerCase());
        }

        //Use linkedHashSet to remove duplicates while maintaining the insertion order
        Set<String> uniqueWords= new LinkedHashSet<>(words);

        //remove special characers from words
        uniqueWords.removeIf(word -> !word.matches("[a-zA-Z]+"));

        List<String> sortedWords= new ArrayList<>(uniqueWords);
        sortedWords.sort((a,b) -> Integer.compare(a.length(),b.length()));

        return sortedWords;

    }

    public static void main(String a[]){
        String sentence= "The quick brown fox jumps over the lazy dog @ .";
        List<String> words= ExtractStringUsingRE.extractWords(sentence);

        System.out.println(words);
    }
}
