package trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class TrieTest {

    private Trie trie;

    @BeforeEach
    public void init() {
        trie = new Trie();
    }

    @Test
    public void add() {
        trie.add("panda");
        System.out.println(trie.getSize());
    }

    @Test
    public void contains() {
        trie.add("panda");
        System.out.println(trie.contains("pan"));
        trie.add("pan");
        System.out.println(trie.contains("pan"));
    }

    @Test
    public void isPrefix() {
        trie.add("panda");
        System.out.println(trie.isPrefix("pan"));
    }

    @Test
    public void testTrie() {
        List<String> words = new ArrayList<>();
        System.out.println("Pride and Prejudice");
        String file = this.getClass()
                .getClassLoader()
                .getResource("pride-and-prejudice.txt")
                .getFile();
        FileOperation.readFile(file, words);
        System.out.println("Total words: " + words.size());

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        System.out.println("Total different size: " + trie.getSize());
    }
}