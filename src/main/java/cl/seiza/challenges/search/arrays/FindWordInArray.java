package cl.seiza.challenges.search.arrays;

import cl.seiza.challenges.search.arrays.domain.Position;

public class FindWordInArray {

    public Position find(String word, Character[] arrayWithWord) {
        if (word == null || word.isEmpty() || arrayWithWord == null) {
            return new Position(0, 0);
        }

        char[] wordChars = word.toCharArray();
        int wordLength   = wordChars.length;

        if (arrayWithWord.length < wordLength) {
            return new Position(0, 0);
        }

        int lastStart = arrayWithWord.length - wordLength;

        for (int i = 0; i <= lastStart; i++) {
            if (matchesAt(arrayWithWord, wordChars, i)) {
                return new Position(i, i + wordLength - 1);
            }
        }

        return new Position(0, 0);
    }

    private boolean matchesAt(Character[] array, char[] word, int offset) {
        for (int j = 0; j < word.length; j++) {
            Character c = array[offset + j];
            if (c == null || c != word[j]) {
                return false;
            }
        }
        return true;
    }
}