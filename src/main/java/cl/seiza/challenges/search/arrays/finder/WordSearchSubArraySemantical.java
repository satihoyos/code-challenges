package cl.seiza.challenges.search.arrays.finder;

import cl.seiza.challenges.search.arrays.domain.Position;
import cl.seiza.challenges.search.arrays.helper.CharacterArrayHelper;

public class WordSearchSubArraySemantical {

    private CharacterArrayHelper helper;

    public WordSearchSubArraySemantical(CharacterArrayHelper helper) {
        this.helper = helper;
    }

    /**
     * Complexity O(n*m) - linear time
     *      n arrayWithWord length
     *      m word length
     * Spatial complexity O(m)
     *
     * Sí, la conversión de word a wordAsCharArray tiene complejidad O(m),
     * donde m es la longitud de word. Sin embargo, como esta operación
     * ocurre una sola vez antes del bucle principal, su impacto en la
     * complejidad total es menor frente al bucle anidado de O(n * m).
     *
     * Resumen:
     *      La conversión inicial es O(m).
     *      El bucle principal es O(n * m).
     *      La complejidad total sigue siendo O(n * m),
     *      ya que O(n * m) + O(m) = O(n * m)
     *      (el término dominante es el del bucle).
     * @param word
     * @param arrayWithWord
     * @return
     */
    public Position find(String word, Character[] arrayWithWord) {

        Character[] wordAsCharArray = word.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Integer     wordLength      = word.length();
        Position    noPosition      = new Position(0, 0);

        for (int i = 0; i < arrayWithWord.length; i++) {

            Integer   charArrLastPosition = i + wordLength - 1;
            if (charArrLastPosition >= arrayWithWord.length) {
                return noPosition;
            }

            Character[] subArray = new Character[wordLength];
            System.arraycopy(arrayWithWord, i, subArray, 0, wordLength);

            if (!this.helper.areInitAndFinalPositionTheSame(wordAsCharArray, subArray) ) {
                continue;
            }

            if (this.helper.areCharsArraysEqual(wordAsCharArray, subArray)) {
                return new Position(i, charArrLastPosition);
            }
        }

        return noPosition;
    }
}
