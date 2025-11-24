package cl.seiza.challenges.search.arrays.finder;

import cl.seiza.challenges.search.arrays.domain.Position;
import cl.seiza.challenges.search.arrays.helper.CharacterArrayHelper;

public class WordSearchSubArrayRecursively {

    private CharacterArrayHelper helper;

    public WordSearchSubArrayRecursively(CharacterArrayHelper helper) {
        this.helper = helper;
    }

    /**
     * Conversión de word a wordAsCharArray: O(m), donde m es la longitud de word.
     * En cada llamada recursiva:
     * System.arraycopy: O(m)
     * areInitAndFinalPositionTheSame: O(1)
     * areCharsArraysEqual: O(m)
     * El número máximo de llamadas recursivas es n - m + 1
     * (donde n es la longitud de arrayWithWord).
     * Por lo tanto, la complejidad temporal total es O((n - m + 1) * m) ≈ O(n * m).
     * Complejidad espacial: O(m) (por los arrays temporales).
     * Resumen:
     * Temporal: O(n * m)
     * Espacial: O(m)
     *
     * @param word
     * @param arrayWithWord
     * @return
     */
    public Position find (String word, Character[] arrayWithWord) {

        Character[] wordAsCharArray = word.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Integer     wordLength      = word.length();
        Character[] subArray        = new Character[wordLength];

        System.arraycopy(arrayWithWord, 0, subArray, 0, wordLength);
        return findPositionRecursively(wordAsCharArray, subArray,  arrayWithWord, 0);
    }

    public Position findPositionRecursively(
                            Character[] wordAsCharArray, Character[] subArray, Character[] arrayWithWord, Integer i) {

        Boolean isWordfound = this.helper.areInitAndFinalPositionTheSame(wordAsCharArray, subArray) &&
                              this.helper.areCharsArraysEqual(wordAsCharArray, subArray);

        Integer   charArrLastPosition = i + wordAsCharArray.length - 1;
        if (isWordfound) {
            return new Position(i, charArrLastPosition);
        } else {
            if (++charArrLastPosition >= arrayWithWord.length) {
                return new Position(0, 0);
            }

            System.arraycopy(arrayWithWord, ++i, subArray, 0, wordAsCharArray.length);
            return findPositionRecursively(wordAsCharArray, subArray, arrayWithWord, i);
        }
    }
}
