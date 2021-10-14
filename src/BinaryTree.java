public class BinaryTree
{
    Node root;

    BinaryTree(){
        Node root;
    }


    Node findNode(int key){
        return findNode(root,key);
    }

    Node findNode(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key > root.key) {
            return findNode(root.right, key);
        }

        return findNode(root.left, key);
    }

    void addNode(int key) {
        root = addNode(root, key);
    }

    Node addNode(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (key < node.key)
        {
            node.left = addNode(node.left, key);
        }
        else if (key > node.key)
        {
            node.right = addNode(node.right, key);
        }

        return node;
    }

    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    Node findLCA(Node node, int n1, int n2)
    {
        if (node == null) {
            return null;
        }

        // If n1 and n2 < root, then the LCA is on the right
        if (node.key > n1 && node.key > n2) {
            return findLCA(node.left, n1, n2);
        }

        // If n1 and n2 > root, then the LCA is on the right
        if (node.key < n1 && node.key < n2) {
            return findLCA(node.right, n1, n2);
        }

        return node;
    }

    public static void main(String[] args){
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

        System.out.print("LCA of 20 and 40: " + tree.findLCA(20, 40).key);

    }

}



