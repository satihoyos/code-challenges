package cl.seiza.challenges.search.arrays;

import cl.seiza.challenges.search.arrays.domain.Position;

public class FindWordInArray {
    public Position find(String word, Character[] arrayWithWord) {
        Character[] wordAsCharArray = word.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Integer     wordLength      = word.length();
        Position    noPosition      = new Position(0, 0);

        for (int i = 0; i < arrayWithWord.length; i++) {

            Integer   charArrLastPosition = i + wordLength - 1;
            if (charArrLastPosition >= arrayWithWord.length) {
                return noPosition;
            }

            Character auxInitChar   = arrayWithWord[i];
            Character auxEndChar    = arrayWithWord[charArrLastPosition];
            Character initChar      = wordAsCharArray[0];
            Character endChar       = wordAsCharArray[wordLength - 1];

            boolean   areCharsEqual = auxInitChar.equals(initChar) && auxEndChar.equals(endChar);

            if (areCharsEqual) {
                int positionInWord = 0;
                for (int j = i; j <= charArrLastPosition; j++) {

                    Character charArry = arrayWithWord[j];
                    Character charWord = wordAsCharArray[positionInWord++];
                    if(!(charArry.compareTo(charWord) == 0)){
                        break;
                    }

                    if(j == charArrLastPosition) {
                        return new Position(i, charArrLastPosition);
                    }
                }
            }
        }

        return noPosition;
    }
}
