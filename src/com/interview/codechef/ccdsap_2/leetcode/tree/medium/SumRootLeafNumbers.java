package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class SumRootLeafNumbers {

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public static void main( String[] args ) {
        /*Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        System.out.println(sumRootToLeaf(head));
*/
        Node head = Node.newNode(4);

        head.left = Node.newNode(9);
        head.right = Node.newNode(0);

        head.left.left = Node.newNode(5);
        head.left.right = Node.newNode(1);

        // System.out.println(sumRootToLeaf(head));

        System.out.println(sumNumbersUsingTwoStacks(head));
    }

    //83 / 110 test cases passed.
    private static int sumRootToLeaf( Node root ) {
        Stack<Pair> stack = new Stack<>();

        if (root.data == 0)
            stack.add(new Pair(root, -1 + ""));
        else
            stack.add(new Pair(root, root.data + ""));

        List<String> list = new ArrayList<>();

        while (!stack.isEmpty()) {

            int size = stack.size();

            while (size-- > 0) {
                Pair pair = stack.pop();

                if (pair.node.left != null) {
                    stack.add(new Pair(pair.node.left, (Objects.equals(pair.val, "-1") ? "" : pair.val) + pair.node.left.data + ""));
                }

                if (pair.node.right != null) {
                    stack.add(new Pair(pair.node.right, (Objects.equals(pair.val, "-1") ? "" : pair.val) + pair.node.right.data + ""));
                }

                if (pair.node.left == null && pair.node.right == null)
                    list.add(pair.val);
            }
        }

        final int[] sum = {0};
        list.forEach(item -> {
                    sum[0] += Long.parseLong(item);
                }
        );

        return sum[0];
    }

    //similar Logic as Mine but using two Stacks: for each branch node and branch sum

    //It is actually a DFS as : FlattenBinaryTreeToLinkedList -> flattenUsingStack
    private static int sumNumbersUsingTwoStacks( Node root ) {

        if (root == null) return 0;

        Stack<Node> nodeList = new Stack<>();
        Stack<Integer> sumList = new Stack<>();

        nodeList.push(root);
        sumList.push(root.data);

        int total = 0;

        while (!nodeList.isEmpty()) {

            root = nodeList.pop();
            int curSum = sumList.pop();

            //if we reach to leaf Node then store total sum
            if (root.left == null && root.right == null) {
                total += curSum;
            }

            if (root.right != null) {
                nodeList.push(root.right);

                //this root.right will be removed in next iteration, so storing sum by multiplying its parent.
                sumList.push(curSum * 10 + root.right.data);
            }

            if (root.left != null) {
                nodeList.push(root.left);
                sumList.push(curSum * 10 + root.left.data);
            }
        }

        return total;
    }

    static class Pair {
        public Node node;
        public String val;

        public Pair( Node node, String val ) {
            this.node = node;
            this.val = val;
        }
    }
}
