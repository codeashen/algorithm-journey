package binarysearchtree;

import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void add() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] nums = {5, -1, 20, 6, -9, 3};
        for (int num : nums) {
            tree.add(num);
        }
        System.out.printf("size: %d\n", tree.size());
        System.out.printf("tree contains 105: %s\n", tree.contains(105));
        
        tree.preOrder();
        System.out.println();
        
        tree.inOrder();
        System.out.println();
        
        tree.postOrder();
        System.out.println();
        
        System.out.println(tree);
    }

    @Test
    public void preOrderNR() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] nums = {5, -1, 20, 6, -9, 3};
        for (int num : nums) {
            tree.add(num);
        }
        tree.preOrder();
        System.out.println();
        tree.preOrderNR();
    }

    @Test
    public void levelOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] nums = {5, -1, 20, 6, -9, 3};
        for (int num : nums) {
            tree.add(num);
        }
        tree.levelOrder();
    }
    
}