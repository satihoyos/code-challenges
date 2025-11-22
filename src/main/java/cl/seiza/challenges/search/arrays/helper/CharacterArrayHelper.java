package cl.seiza.challenges.search.arrays.helper;

public class CharacterArrayHelper {
    public Boolean areInitAndFinalPositionTheSame(Character[] array1, Character[] array2) {
        if (array1.length != array2.length) {
            return Boolean.FALSE;
        }

        Character initCharArray1 = array1[0];
        Character endCharArray1  = array1[array1.length - 1];

        Character initCharArray2 = array2[0];
        Character endCharArray2  = array2[array2.length - 1];

        return initCharArray1.equals(initCharArray2) && endCharArray1.equals(endCharArray2);
    }

    public Boolean areCharsArraysEqual(Character[] array1, Character[] array2) {
        if (array1.length != array2.length) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
