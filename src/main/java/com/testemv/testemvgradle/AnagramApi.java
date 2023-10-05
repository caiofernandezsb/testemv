package com.testemv.testemvgradle;

import com.testemv.testemvgradle.exceptions.NonLetterCharacterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class AnagramApi {

    @Autowired
    private AnagramService anagramService;
    @GetMapping("/areanagrams/{firstWord}/{secondWord}")
    public ResponseEntity<?> areAnagrams(
            @PathVariable String firstWord,
            @PathVariable String secondWord

    ) {
        try {
            boolean areAnagrams = anagramService.checkWhetherIsAnagram(firstWord, secondWord);
            return ResponseEntity.ok(areAnagrams);
        }  catch (NonLetterCharacterException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}