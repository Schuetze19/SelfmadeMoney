package com.example.dennis.selfmademoney.util;

import java.util.ArrayList;
import java.util.List;

public class Shuffle {
    /**
     * Mischt den String durch, sodass wir verschiedene "Testdaten" haben
     * @param input String, der gurchgemischt werden soll
     * @return Durchgemischter String
     */
    public static String shuffle(String input){
        List<Character> characters = new ArrayList<>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }
}