package cl.seiza.challenges.search.arrays;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        String filename = "benchmark.bin";
        FindWordInArray findWord = new FindWordInArray();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("Loading char array from file: " + filename);
            long start = System.currentTimeMillis();
            Character[] arrayWords = (Character[]) ois.readObject();
            long end = System.currentTimeMillis();
            System.out.println("Loaded in " + (end - start) + " ms");
            System.out.println("Starting benchmark");
            start = System.currentTimeMillis();
            findWord.find("helloworld", arrayWords);
            end = System.currentTimeMillis();
            System.out.println("Benchmark result: " + (end - start) + " ms");
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing array: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static char generateRandomChar() {
        Random random = new Random();
        char c = (char)(random.nextInt(26) + 'a');
        return c;
    }

    private static void generateFile() {
        int size = Math.powExact(2, 26);
        Character[] array = new Character[size];
        for(int i = 0; i < size; i++) {
            if(i == size/2) {
                array[i] = 'h';
                array[i+1] = 'o';
                array[i+2] = 'l';
                array[i+3] = 'a';
                array[i+4] = 'm';
                array[i+5] = 'u';
                array[i+6] = 'n';
                array[i+7] = 'd';
                array[i+8] = 'o';
                i = i + 8;
            }
            array[i] = generateRandomChar();
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("benchmark.bin"))) {
            oos.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
