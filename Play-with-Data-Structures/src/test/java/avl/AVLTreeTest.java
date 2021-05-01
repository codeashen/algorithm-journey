package avl;

import org.junit.Test;
import util.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class AVLTreeTest {

    @Test
    public void avlTree() {
        System.out.println("Pride and Prejudice");
        String file = this.getClass()
                .getClassLoader()
                .getResource("pride-and-prejudice.txt")
                .getFile();

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(file, words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String> avlTree = new AVLTree<>();
            for (String word : words) {
                avlTree.add(word);
            }
            
            System.out.println("Total different words: " + avlTree.size());
            System.out.println("is binary search tree: " + avlTree.isBST());
            System.out.println("is balanced tree: " + avlTree.isBalanced());

            for (String word : words) {
                avlTree.remove(word);
                if (!avlTree.isBST() || !avlTree.isBalanced()) {
                    throw new IllegalStateException("Not match AVL tree while remove!");
                }
            }
        }

        System.out.println("Test passed.");
    }

}