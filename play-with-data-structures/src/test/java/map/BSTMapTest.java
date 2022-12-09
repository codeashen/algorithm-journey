package map;

import org.junit.jupiter.api.Test;
import util.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class BSTMapTest {

    @Test
    public void add() {
        System.out.println("Pride and Prejudice");
        String file = this.getClass()
                .getClassLoader()
                .getResource("pride-and-prejudice.txt")
                .getFile();

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(file, words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}