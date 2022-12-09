package set;

import org.junit.jupiter.api.Test;
import util.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class BSTSetTest {

    @Test
    public void wordCount1() {
        List<String> words = new ArrayList<>();
        System.out.println("a tale of two cities");
        String file = this.getClass()
                .getClassLoader()
                .getResource("a-tale-of-two-cities.txt")
                .getFile();
        FileOperation.readFile(file, words);
        System.out.println("Total words: " + words.size());

        BSTSet<String> set = new BSTSet<>();
        for (String word : words) {
            set.add(word);
        }
        System.out.println("Total different size: " + set.getSize());
    }

    @Test
    public void wordCount2() {
        List<String> words = new ArrayList<>();
        System.out.println("pride and prejudice");
        String file = this.getClass()
                .getClassLoader()
                .getResource("pride-and-prejudice.txt")
                .getFile();
        FileOperation.readFile(file, words);
        System.out.println("Total words: " + words.size());

        BSTSet<String> set = new BSTSet<>();
        for (String word : words) {
            set.add(word);
        }
        System.out.println("Total different size: " + set.getSize());
    }
}