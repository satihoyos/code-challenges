package cl.seiza.challenges.search.arrays;

import cl.seiza.challenges.search.arrays.domain.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindWordInArray {
    public Position find(String word, Character[] arrayWithWord) {

        // Preparation
        char firstCharToFind = word.charAt(0);
        List<Integer> positionFounded = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Character ch : arrayWithWord) {
            sb.append(ch);
        }
        String arrayToString = sb.toString();

        // Find positions
        int indexFounded = -1;
        int lastIndexBeforeCut = 0;
        String newWordCutted = arrayToString;
        do{
            newWordCutted = newWordCutted.substring(indexFounded + 1);
            indexFounded = newWordCutted.indexOf(firstCharToFind);
            if(indexFounded != -1){
                lastIndexBeforeCut = lastIndexBeforeCut + indexFounded;
                positionFounded.add(lastIndexBeforeCut);
                lastIndexBeforeCut++;
            }
        }while(indexFounded != -1);

        if(positionFounded.isEmpty()){
            return new Position(0, 0);
        }

        // Preparing concurrency
        final int NUM_THREADS = positionFounded.size();
        List<Position> positionFoundedSuccess = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threadsList = new ArrayList<>();

        // Create a list of concurrency we need to start
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadId = i;
            threadsList.add(Thread.ofPlatform().start(() -> {
                try {
                    System.out.println("Thread " + threadId + ": buscando la posición " + positionFounded.get(threadId));
                    if(isWordLocatedInThisPosition(positionFounded.get(threadId), word, arrayToString)){
                        System.out.println("Thread " + threadId + ":La palabra se encuentra en la posición " + positionFounded.get(threadId));
                        positionFoundedSuccess.add(
                                new Position(
                                        positionFounded.get(threadId),
                                        positionFounded.get(threadId) + word.length() - 1
                                ));
                    } else {
                        System.out.println("Thread " + threadId + ":La palabra no se encontró en esta posición");
                    }
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        // wait for all executed thread
        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // validations and result
        if(positionFoundedSuccess.isEmpty()){
            return new Position(0, 0);
        }
        return positionFoundedSuccess.getFirst();
    }

    private boolean isWordLocatedInThisPosition(int position, String word, String arrayToString){
        String newWordToFind = arrayToString.substring(position + 1);
        String wordSplitedWithoutFirstWord = word.substring(1);

        int counterCheck = 0;
        for (int i = 0; i < wordSplitedWithoutFirstWord.length(); i++) {
            if(newWordToFind.charAt(i) == wordSplitedWithoutFirstWord.charAt(i)){
                counterCheck++;
                if(counterCheck == wordSplitedWithoutFirstWord.length()){
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
