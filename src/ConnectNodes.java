import java.util.*;

/**
 * Definition for a Node.
 * 116. 填充每个节点的下一个右侧节点指针
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        val = _val;
    }


}

public class ConnectNodes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        String[] nodes = sc.nextLine().replace("[", "").replace("]", "").split(",");
        Node root = buildTree(nodes);

        // 连接树的同层节点
        Node result = connect(root);

        // 输出结果
        printTree(result);

        sc.close();
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    private static Node buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(nodes[0].trim()));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < nodes.length) {
            Node current = queue.poll();

            if (index < nodes.length && !nodes[index].trim().equals("null")) {
                current.left = new Node(Integer.parseInt(nodes[index].trim()));
                queue.offer(current.left);
            }
            index++;

            if (index < nodes.length && !nodes[index].trim().equals("null")) {
                current.right = new Node(Integer.parseInt(nodes[index].trim()));
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                System.out.print(node.val + " ");
                if (node.next != null) {
                    System.out.print("-> " + node.next.val + " ");
                } else {
                    System.out.print("-> null ");
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}
