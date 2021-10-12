public class BinaryTree
{
    Node root;

    Node findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    // function that returns the pointer to the LCA of two given nodes
    // assumes n1 and n2 are present in the tree

    Node findLCA(Node node, int n1, int n2)
    {

        if (node == null)
            return null;

        // if n1 or n2 matches match the root, return the root,
        // since that's the LCA
        if (node.data == n1 || node.data == n2)
            return node;


        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);


        // if both of the calls above don't return null,
        // then this is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;

        // otherwise check if the left  or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    // program to test the LCA function
    public static void main(String[] args) {


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


        System.out.println("The LCA of 6 and 7 = " + tree.findLCA(6, 7).data); // 3
        System.out.println("The LCA of 2 and 6 = " + tree.findLCA(2, 6).data); // 1
        System.out.println("The LCA of 4 and 5 = " + tree.findLCA(4, 5).data); // 2
        System.out.println("The LCA of 3 and 7 = " + tree.findLCA(3, 7).data); // 3

    }
}
