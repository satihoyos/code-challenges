package cl.seiza.challenges.search.arrays;

import cl.seiza.challenges.search.arrays.domain.Position;
import cl.seiza.challenges.search.arrays.finder.WordSearchSubArrayBothDirections;
import cl.seiza.challenges.search.arrays.finder.WordSearchSubArrayRecursively;
import cl.seiza.challenges.search.arrays.finder.WordSearchSubArray;
import cl.seiza.challenges.search.arrays.finder.WordSearchSubArraySemantical;
import cl.seiza.challenges.search.arrays.helper.CharacterArrayHelper;

public class FindWordInArray {
    public Position find2(String word, Character[] arrayWithWord) {
        WordSearchSubArray wordSearchSubArray = new WordSearchSubArray();
        long start = System.currentTimeMillis();
        Position position = wordSearchSubArray.find(word, arrayWithWord);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to find the word's position: " + (end - start) + " ms");
        return position;
    }

    public Position find3(String word, Character[] arrayWithWord) {
        WordSearchSubArraySemantical wordSearch = new WordSearchSubArraySemantical(new CharacterArrayHelper());
        long start = System.currentTimeMillis();
        Position position = wordSearch.find(word, arrayWithWord);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to find the word's position: " + (end - start) + " ms");
        return position;
    }

    public Position find4 (String word, Character[] arrayWithWord) {
        WordSearchSubArrayRecursively wordSearch = new WordSearchSubArrayRecursively(new CharacterArrayHelper());
        long start = System.currentTimeMillis();
        Position position = wordSearch.find(word, arrayWithWord);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to find the word's position: " + (end - start) + " ms");
        return position;
    }

    public Position find (String word, Character[] arrayWithWord) {
        WordSearchSubArrayBothDirections wordSearch = new WordSearchSubArrayBothDirections(new CharacterArrayHelper());
        long start = System.currentTimeMillis();
        Position position = wordSearch.find(word, arrayWithWord);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to find the word's position: " + (end - start) + " ms");
        return position;
    }

}
