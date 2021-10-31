import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLCA {

    @Test
    public void BST_testNode() {
       Node node = new Node(1);
       assertEquals(1, node.key);
       assertNull(node.left);
       assertNull(node.right);
    }

    @Test
    public void BST_testBinaryTree() {
        BinaryTree tree = new BinaryTree();
        assertNull(tree.root);
    }

    @Test
    public void BST_testFindNodeNull() {
        BinaryTree tree = new BinaryTree();
        // where root = null
        assertNull(tree.findNode(1));
    }

    @Test
    public void BST_testFindNodeEqualRoot() {
        BinaryTree tree = new BinaryTree();
        // where the root is equal to the node we're finding
        tree.addNode(10);
        assertEquals(10, tree.findNode(10).key);
    }

    @Test
    public void BST_testFindNodeBiggerRoot() {
        BinaryTree tree = new BinaryTree();
        // where the root is less than the node we're finding
        tree.addNode(10);
        tree.addNode(20);
        assertEquals(20, tree.findNode(20).key);
    }

    @Test
    public void BST_testFindNodeSmallerRoot() {
        BinaryTree tree = new BinaryTree();
        // where the root is less than the node we're finding
        tree.addNode(20);
        tree.addNode(10);
        assertEquals(10, tree.findNode(10).key);
    }

    @Test
    public void BST_testLeft() {
        BinaryTree tree = new BinaryTree();

        tree.addNode(10);
        tree.addNode(5);
        assertEquals(tree.findNode(5), tree.findNode(10).left);
    }

    @Test
    public void BST_testRight() {
        BinaryTree tree = new BinaryTree();

        tree.addNode(10);
        tree.addNode(15);
        assertEquals(tree.findNode(15), tree.findNode(10).right);
    }

    @Test
    public void BST_testLCANull() {
        BinaryTree tree = new BinaryTree();

        assertNull(tree.findLCA(10,20));
    }

    @Test
    public void BST_testLCASimple() {
        BinaryTree tree = new BinaryTree();

        tree.addNode(20);
        tree.addNode(10);
        tree.addNode(30);

        assertEquals(tree.findNode(20), tree.findLCA(10,30));
    }

    @Test
    public void BST_testLCA() {
        BinaryTree tree = new BinaryTree();
         /* BST_testing for the following binary tree:
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


    @Test
    public void DAG_testDAGraph() {
        DAGraph graph = new DAGraph(1);
        assertEquals(1, graph.getNumberOfNodes());
        assertEquals(2, graph.getAdjList().length);
    }

    @Test
    public void DAG_testIsEmpty() {
        DAGraph graph = new DAGraph(0);
        assertTrue(graph.isEmpty());
    }

    @Test
    public void DAG_testAddEdge() {
        DAGraph graph = new DAGraph(0);
        assertTrue(graph.isEmpty());
    }

    @Test
    public void DAG_testLCASimple() {
        DAGraph graph = new DAGraph(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertEquals(1, graph.LCA(3, 2));
        assertEquals(1, graph.LCA(1, 2));
    }

    @Test
    public void DAG_testLCA() {

        DAGraph graph = new DAGraph(9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        //graph.printGraph();

        assertEquals(2, graph.LCA(5, 8));
        assertEquals(1, graph.LCA(4, 2));
        assertEquals(2, graph.LCA(2, 7));
        assertEquals(7, graph.LCA(8, 7));
    }

    @Test
    public void DAG_testLCANoEdges() {
        DAGraph graph = new DAGraph(3);
        assertEquals(0, graph.LCA(1, 2));
    }

    @Test
    public void DAG_testLCADoubleEntries() {

        DAGraph graph = new DAGraph(9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        //graph.printGraph();

        assertEquals(1, graph.LCA(1, 1));
        assertEquals(2, graph.LCA(2, 2));
        assertEquals(3, graph.LCA(3, 3));
        assertEquals(4, graph.LCA(4, 4));
        assertEquals(5, graph.LCA(5, 5));
        assertEquals(6, graph.LCA(6, 6));
        assertEquals(7, graph.LCA(7, 7));
        assertEquals(8, graph.LCA(8, 8));
        assertEquals(9, graph.LCA(9, 9));

    }

    @Test
    public void DAG_testHasCycle() {

        // Creating a graph with a cycle
        DAGraph graph1 = new DAGraph(3);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 1);
        assertTrue(graph1.hasCycle());

        // Creating a graph without a cycle
        DAGraph graph2 = new DAGraph(3);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        assertFalse(graph2.hasCycle());

    }

    @Test
    public void DAG_testContainsEdge() {

        DAGraph graph = new DAGraph(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertTrue(graph.containsEdge(1,2));
        assertFalse(graph.containsEdge(3,2));

    }

    @Test
    public void DAG_testRemoveEdge() {

        DAGraph graph = new DAGraph(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertTrue(graph.containsEdge(1,2));
        graph.removeEdge(1,2);
        assertFalse(graph.containsEdge(1,2));

    }

}
