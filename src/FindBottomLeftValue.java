import java.util.*;

/**
 * Definition for a binary tree node.
 * 513.找树左下角的值
 */


public class FindBottomLeftValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        String[] nodes = sc.nextLine().replace("[", "").replace("]", "").split(",");
        TreeNode root = buildTree(nodes);

        // 查找最底层最左边的值
        int result = findBottomLeftValue(root);

        // 输出结果
        System.out.println(result);

        sc.close();
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.right != null) { // 先右
                queue.add(cur.right);
            }
            if (cur.left != null) {  // 后左
                queue.add(cur.left);
            }
        }
        return cur.val;
    }

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
