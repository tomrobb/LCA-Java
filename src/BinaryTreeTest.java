import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testNode() {
       Node node = new Node(1);
       assertEquals(1, node.key);
       assertNull(node.left);
       assertNull(node.right);
    }

    @Test
    void testBinaryTree() {
        BinaryTree tree = new BinaryTree();
        assertNull(tree.root);
    }

    @Test
    void testFindNodeNull() {
        BinaryTree tree = new BinaryTree();
        // where root = null
        assertNull(tree.findNode(1));
    }

    @Test
    void testFindNodeEqualRoot() {
        BinaryTree tree = new BinaryTree();
        // where the root is equal to the node we're finding
        tree.addNode(10);
        assertEquals(10, tree.findNode(10).key);
    }

    @Test
    void testFindNodeBiggerRoot() {
        BinaryTree tree = new BinaryTree();
        // where the root is less than the node we're finding
        tree.addNode(10);
        tree.addNode(20);
        assertEquals(20, tree.findNode(20).key);
    }

    @Test
    void testFindNodeSmallerRoot() {
        BinaryTree tree = new BinaryTree();
        // where the root is less than the node we're finding
        tree.addNode(20);
        tree.addNode(10);
        assertEquals(10, tree.findNode(10).key);
    }

    @Test
    void testLeft() {
        BinaryTree tree = new BinaryTree();

        tree.addNode(10);
        tree.addNode(5);
        assertEquals(tree.findNode(5), tree.findNode(10).left);
    }

    @Test
    void testRight() {
        BinaryTree tree = new BinaryTree();

        tree.addNode(10);
        tree.addNode(15);
        assertEquals(tree.findNode(15), tree.findNode(10).right);
    }

    @Test
    void testLCANull() {
        BinaryTree tree = new BinaryTree();

        assertNull(tree.findLCA(10,20));
    }

    @Test
    void testLCASimple() {
        BinaryTree tree = new BinaryTree();

        tree.addNode(20);
        tree.addNode(10);
        tree.addNode(30);

        assertEquals(tree.findNode(20), tree.findLCA(10,30));
    }

    @Test
    void testLCA() {
        BinaryTree tree = new BinaryTree();
         /* testing for the following binary tree:
                              35
                         /         \
                        20            50
                    /       \     /     \
                  10        30    40       70
         */

        tree.addNode(35);
        tree.addNode(20);
        tree.addNode(50);
        tree.addNode(10);
        tree.addNode(30);
        tree.addNode(40);
        tree.addNode(70);
        assertEquals(tree.findNode(20), tree.findLCA(10,30));
        assertEquals(tree.findNode(50), tree.findLCA(40,70));
        assertEquals(tree.findNode(20), tree.findLCA(10,20));
        assertEquals(tree.findNode(50), tree.findLCA(50,70));
        assertEquals(tree.findNode(35), tree.findLCA(10,70));
    }












}