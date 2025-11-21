package cl.seiza;

import cl.seiza.challenges.search.arrays.FindWordInArray;
import cl.seiza.challenges.search.arrays.domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindWordInArrayTest {

    private FindWordInArray findWordInArray = new FindWordInArray();

    @Test
    public void position_word_carro_in_array_Should_be_0_and_4() {
        String word = "carro";
        Character[] arrayWithWord = new Character[]{'c', 'a', 'r', 'r', 'o', 'a', 'd', 'r', 'f'};
        Position positions = findWordInArray.find(word, arrayWithWord);
        Assertions.assertTrue(positions.isSamePosition(0, 4));
    }

    @Test
    public void position_word_carro_in_array_Should_be_4_and_8() {
        String word = "carro";
        Character[] arrayWithWord = new Character[]{'a', 'b', 'f','c','c', 'a', 'r', 'r', 'o', 'a', 'd', 'r', 'f'};
        Position positions = findWordInArray.find(word, arrayWithWord);
        Assertions.assertTrue(positions.isSamePosition(0, 4));
    }

    @Test
    public void position_word_carro_in_array_Should_be_5_and_9() {
        String word = "carro";
        Character[] arrayWithWord = new Character[]{'a', 'd', 'r', 'f', 'g', 'c', 'a', 'r', 'r', 'o'};
        Position positions = findWordInArray.find(word, arrayWithWord);
        Assertions.assertTrue(positions.isSamePosition(5, 9));
    }
}
