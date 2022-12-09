package map;

import org.junit.jupiter.api.Test;
import util.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class AVLMapTest {

    @Test
    public void avlMap() {
        System.out.println("Pride and Prejudice");
        String file = this.getClass()
                .getClassLoader()
                .getResource("pride-and-prejudice.txt")
                .getFile();

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(file, words)) {
            System.out.println("Total words: " + words.size());

            AVLMap<String, Integer> map = new AVLMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    Integer integer = map.get(word);
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

    @Test
    public void add() {
        AVLMap<Integer, Integer> map = new AVLMap<>();
        for (int i = 0; i < 10; i++) {
            map.add(i, i);
        }
        System.out.println("size: " + map.getSize());
        System.out.println("contains 1: " + map.contains(1));
        System.out.println("1 - " + map.get(1));
        map.set(1, 10);
        System.out.println("1 - " + map.get(1));
        System.out.println("remove 9 - " + map.remove(9));
        System.out.println("contains 9: " + map.contains(9));
        
    }
}