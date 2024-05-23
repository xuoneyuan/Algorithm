import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ZigzagLevelOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        String[] nodes = sc.nextLine().replace("[", "").replace("]", "").split(",");
        TreeNode root = buildTree(nodes);

        // 进行Z字形层序遍历
        List<List<Integer>> result = zigzagLevelOrder(root);

        // 输出结果
        for (List<Integer> level : result) {
            System.out.println(level);
        }

        sc.close();
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
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
