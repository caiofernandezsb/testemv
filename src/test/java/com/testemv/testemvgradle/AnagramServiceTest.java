package com.testemv.testemvgradle;

import com.testemv.testemvgradle.exceptions.NonLetterCharacterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramServiceTest {

    private final AnagramService anagramService = new AnagramService();

    @Test
    public void testAreAnagrams() {
        assertTrue(anagramService.checkWhetherIsAnagram("listen", "silent"));
        assertTrue(anagramService.checkWhetherIsAnagram("abc", "bca"));
        assertTrue(anagramService.checkWhetherIsAnagram("LUA", "ula"));
        assertFalse(anagramService.checkWhetherIsAnagram("hello", "world"));
        assertFalse(anagramService.checkWhetherIsAnagram("abc", "abcd"));
        assertFalse(anagramService.checkWhetherIsAnagram("abcf", "abcd"));

        NonLetterCharacterException exception = assertThrows(NonLetterCharacterException.class, () -> {
            anagramService.checkWhetherIsAnagram("abc*", "abcd");
            anagramService.checkWhetherIsAnagram("aeio2", "aeiou");
        });

        assertEquals("Erro - Foi detectado caractere especial ou numérico", exception.getMessage());
    }

}
