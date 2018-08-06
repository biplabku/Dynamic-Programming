import jdk.nashorn.api.tree.Tree;

public class TreeNode {
    public TreeNode leftChild;
    public TreeNode rightChild;
    public int data;

    public TreeNode(int value) {
        data = value;
        leftChild = rightChild = null;
    }
}
