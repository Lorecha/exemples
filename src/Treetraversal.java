import java.util.Stack;

public class Treetraversal {
    public static void main(String[] args) {
// non-recursive java program for inorder traversal

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
/* Class containing left and right child of
current node and key value*/


        /* Class to print the inorder traversal */
    }

}
