package easy.highestscoringword;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
For example, the score of abad is 8 (1 + 2 + 1 + 4).
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid.
 */
public class HighestScoringWord {

    /**
     * This function takes a phrase as a parameter. It turns it into an array, transforming the words into Integers (it adds the ASCII values of each character composing the word, and returns the max value).
     * If there are two words with the same value, it should return the one appearing earliest in the original string.
     * @param phrase
     * @return: A single string containing the word with the highest score (ASCII Value)
     */
    public static String highestScoringWord(String phrase) {
        String[] arrayOfWords = phrase.trim().toLowerCase().split(" ");
        int[] arrayOfASCII = new int[arrayOfWords.length];

        int index = 0;
        for (String word: arrayOfWords) {
            for (int i = 0; i < word.length(); i++) {
                arrayOfASCII[index] += (int) word.charAt(i) - 96;
            }
            index++;
        }

        int maxValue = Arrays.stream(arrayOfASCII).max().orElseThrow();
        int indexContainingMaxValue = IntStream.range(0, arrayOfASCII.length)
                .filter(i -> arrayOfASCII[i] == maxValue)
                .findFirst()
                .orElse(-1);

        return phrase.split(" ")[indexContainingMaxValue];
    }

    public static void main(String[] args) {
        String phrase = "What time are we climbing up the volcano";
        String word = highestScoringWord(phrase);
        System.out.println(word);
    }
}
