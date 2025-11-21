package cl.seiza.challenges.search.arrays;

import java.util.ArrayList;
import java.util.Optional;

import cl.seiza.challenges.search.arrays.domain.Position;

public class FindWordInArray {

    record Node (int hash, int start, int end) {};

    public Position find(String word, Character[] arrayWithWord) {
        int wordHash = computeWordHash(word);
        int wordLen = word.length();
        ArrayList<Node> array = new ArrayList<>();
        for (int i = 0; i < arrayWithWord.length - (wordLen-1); i++) {
            array.add(new Node(computeChunkHash(arrayWithWord, i, wordLen), i, i + wordLen - 1));
        }
        Optional<Node> nodeFound = array.stream().filter(n -> n.hash == wordHash).findFirst();
        if (nodeFound.isPresent()) {
            return new Position(nodeFound.get().start, nodeFound.get().end);
        }
        return new Position(0, 0);
    }

    /**
     * Calcula el valor hash de cada caracter de la palabra usando la formula
     * 31*(int)c.
     * 
     * Complejidad: O(n)
     * @param word
     * @return hash de la palabra
     */
    private int computeWordHash(String word) {
        int hash = 0;
        char[] stream = word.toCharArray();
        for (char c : stream) {
            hash = hash + 31*(int)c;
        }
        return hash;
    }

    /**
     * Calcula el valor de hash de un chunk del array.
     * Entiendase por chunk a una sección del arreglo
     * 
     * Complejidad: O(n)
     * @param stream El listado de caracteres
     * @param start posición de inicio del chunk
     * @param len longitud de la palabra
     * @return hash del chunk
     */
    private int computeChunkHash(Character[] stream, int start, int len) {
        int hash = 0;
        for(int i = start; i < start + len && i < stream.length; i++) {
            hash = hash + 31*(int)stream[i];
        }
        return hash;
    }
}