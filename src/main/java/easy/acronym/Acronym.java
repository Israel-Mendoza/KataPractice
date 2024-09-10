package easy.acronym;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Given two strings, determine if the first string is a valid acronym for the second.
 */

public class Acronym {

    public static void main(String[] args) {
        String usb = "USB";
        String universalSerialBus = "Universal Serial Bus";
        System.out.printf("%s is an acronym for %s: %b\n", usb, universalSerialBus, isAcronym(usb, universalSerialBus));

    }

    public static boolean isAcronym(String abbreviation, String words){
        // Creating an actual acronym using the stream to filter only the initial letters of the words (applying uppercase)
        String acronym = Arrays.stream(words.split(" "))
                .map(word -> String.valueOf(word.charAt(0)))
                .map(String::toUpperCase)
                .collect(Collectors.joining()); // A Useful collector to concatenate the characters into a string.

        return acronym.equalsIgnoreCase(abbreviation);
    }
}
