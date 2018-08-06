import java.util.Scanner;

public class secondLargBST {
    public TreeNode root;

    public secondLargBST() {
        root = null;
    }

    public int getSecondLargest(TreeNode node) {
        if(node.leftChild != null && node.rightChild == null) {
            return getLargest(node.leftChild);
        }
        if(node.rightChild != null  && node.rightChild.leftChild == null && node.rightChild.rightChild == null) {
            return node.data;
        }
        return getSecondLargest(node.rightChild);
    }

    public int getLargest(TreeNode node) {
        if(node.rightChild != null) {
            return getLargest(node.rightChild);
        }
        return node.data;
    }

    public void insertNode(TreeNode node) {
        if(root == null) {
            root = node;
        }else {
            TreeNode cur = root;
            TreeNode prev = null;
            while(cur != null) {
                prev = cur;
                if(cur.data >= node.data) {
                    cur = cur.leftChild;
                    if(cur == null) {
                        prev.leftChild = node;
                    }
                }else {
                    cur = cur.rightChild;
                    if(cur == null) {
                        prev.rightChild = node;
                    }
                }
            }

        }
    }

    public void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.leftChild);
            System.out.println(node.data);
            inOrder(node.rightChild);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        secondLargBST ss = new secondLargBST();
        ss.insertNode(new TreeNode(12));
        ss.insertNode(new TreeNode(5));
        ss.insertNode(new TreeNode(4));
        ss.insertNode(new TreeNode(10));
        ss.insertNode(new TreeNode(15));
        ss.insertNode(new TreeNode(13));
        ss.insertNode(new TreeNode(18));
        ss.insertNode(new TreeNode(16));
        ss.insertNode(new TreeNode(17));

        // ss.inOrder(ss.getRoot());
        System.out.println(ss.getSecondLargest(ss.getRoot()));
    }

}
