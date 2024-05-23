import java.util.*;

/**
 * Definition for a binary tree node.
 * LCR 046. 二叉树的右视图
 */


public class RightSideView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        String[] nodes = sc.nextLine().replace("[", "").replace("]", "").split(",");
        TreeNode root = buildTree(nodes);

        // 获取二叉树的右视图
        List<Integer> result = rightSideView(root);

        // 输出结果
        for (int val : result) {
            System.out.print(val + " ");
        }
        sc.close();
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            int tmp = 0;
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                tmp = node.val;
            }
            res.add(tmp);
        }

        return res;
    }

    // 构建二叉树的辅助方法
    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();

            if (index < nodes.length && !nodes[index].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[index].trim()));
                queue.offer(current.left);
            }
            index++;

            if (index < nodes.length && !nodes[index].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[index].trim()));
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }
}
