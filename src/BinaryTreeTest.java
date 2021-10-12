import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testLCA() {
        /* testing for the following binary tree:
                              1
                         /         \
                        2            3
                    /       \     /     \
                  4         5    6        7
         */

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left = new Node(7);

        assertEquals(3, tree.findLCA(6, 7).data);
        assertEquals(1, tree.findLCA(2, 6).data);
        assertEquals(2, tree.findLCA(4, 5).data);
        assertEquals(3, tree.findLCA(3, 7).data);
    }

}