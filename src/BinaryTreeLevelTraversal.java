import java.util.*;

public class BinaryTreeLevelTraversal {

    public TreeNode root;

    public BinaryTreeLevelTraversal() {

    }


    // We will be using Queue for this solution.
    // Queue will help me in doing a breadth first seach
    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> thelist = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> l = new ArrayList<>();
        l.add(node.data);
        thelist.add(l);
        while(!queue.isEmpty()) {
            l.clear();
            TreeNode n1 = queue.poll();
            if(n1.leftChild != null) {
                l.add(n1.leftChild.data);
            }
            if(n1.rightChild != null) {
                l.add(n1.rightChild.data);
            }
            thelist.add(l);
        }
        return thelist;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> temp=new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return temp;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                layer.add(n.data);
                if(n.leftChild != null) {
                    queue.add(n.leftChild);
                }
                if(n.rightChild != null) {
                    queue.add(n.rightChild);
                }
            }
            temp.add(layer);
        }
        return temp;
    }

    public static void main(String[] args) {
        BinaryTreeLevelTraversal bs = new BinaryTreeLevelTraversal();
        bs.root = new TreeNode(12);
        bs.root.leftChild = new TreeNode(1);
        bs.root.leftChild.rightChild = new TreeNode(3);
        bs.root.rightChild = new TreeNode(5);
        bs.root.rightChild.rightChild = new TreeNode(7);
        System.out.println(bs.levelOrderTraversal(bs.root));

    }
}
