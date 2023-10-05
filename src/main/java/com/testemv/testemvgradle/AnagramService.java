package com.testemv.testemvgradle;

import com.testemv.testemvgradle.exceptions.NonLetterCharacterException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/* This code was developed for evaluation purposes, specifically to be used on MV Informatica`s DEV III hiring process*/
@Service
public class AnagramService {
    public boolean checkWhetherIsAnagram(String firstWord, String secondWord) {
        return isValidAnagram(firstWord, secondWord);

    }

    private boolean isValidAnagram(String firstWord, String secondWord) {
        /* This block is meant to check if strings lengths matches and if it doesn't there's no way to be considered as anagrams
        Even though this block works with invalid anagrams, it makes sense to verify numeric and special characters occurrences*/
        if (firstWord.length() != secondWord.length()) {
            checkChar(firstWord);
            checkChar(secondWord);
            return false;
        }

        checkChar(firstWord);
        checkChar(secondWord);

        //Converting to lower case, because upper capitalization is interpreted differently by the computer
        String stWord = firstWord.toLowerCase();
        String ndWord = secondWord.toLowerCase();

        //Calling the method responsible for sorting the letters
        String sortedRepresentation1 = sortCharacters(stWord);
        String sortedRepresentation2 = sortCharacters(ndWord);

        //Return a boolean statement
        return sortedRepresentation1.equals(sortedRepresentation2);
    }

    private void checkChar(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!Character.isLetter(ch)) {
                throw new NonLetterCharacterException("Erro - Foi detectado caractere especial ou numérico");
            }
        }
    }

    private String sortCharacters(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
