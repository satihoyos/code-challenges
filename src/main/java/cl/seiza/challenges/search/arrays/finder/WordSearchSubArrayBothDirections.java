package cl.seiza.challenges.search.arrays.finder;

import cl.seiza.challenges.search.arrays.domain.Position;
import cl.seiza.challenges.search.arrays.helper.CharacterArrayHelper;

import java.util.Arrays;

public class WordSearchSubArrayBothDirections {

    private CharacterArrayHelper helper;

    public WordSearchSubArrayBothDirections(CharacterArrayHelper helper) {
        this.helper = helper;
    }

    /**
     * @param word
     * @param arrayWithWord  O(N * M)
     * @return
     */
    public Position find (String word, Character[] arrayWithWord) {

        Character[] wordAsCharArray = word.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Position    noPosition      = new Position(0, 0);
        int         wordLength      = word.length();

        for (int posiInitCharRight = 0; posiInitCharRight < arrayWithWord.length; posiInitCharRight++) {

            int  posiFinalCharRight = posiInitCharRight + wordLength - 1;
            if (posiFinalCharRight >= arrayWithWord.length) {
                break;
            }

            int posiInitCharLeft    = arrayWithWord.length - 1 - posiInitCharRight;
            int posiFinalCharLeft   = posiInitCharLeft - wordLength + 1;

            Character[] subArr      = this.helper.getSubArray(arrayWithWord, posiInitCharRight, wordLength);
            if(this.isSubArrEqualWordArr(wordAsCharArray, subArr)) {
                return new Position(posiInitCharRight, posiFinalCharRight);
            }

            subArr  = this.helper.getSubArray(arrayWithWord, posiInitCharRight, wordLength);
            if(isSubArrEqualWordArr(wordAsCharArray, subArr)) {
                return new Position(posiFinalCharLeft, posiInitCharLeft );
            }

            if (posiInitCharLeft == posiFinalCharRight && posiFinalCharLeft == posiInitCharRight) {
                break;
            }
        }

        return noPosition;
    }

    public Boolean isSubArrEqualWordArr(Character[] wordArr, Character[] subArray) {
        return this.helper.areInitAndFinalPositionTheSame(wordArr, subArray) && Arrays.equals(wordArr, subArray);
                //this.helper.areCharsArraysEqual(wordArr, subArray);
    }
}
