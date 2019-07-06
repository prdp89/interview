package com.interview.tree;

/**
 * Date 07/07/2014 
 * @author tusroy
 * 
 * Youtube link - https://youtu.be/bmaeYtlO2OE
 * Youtube link - https://youtu.be/_SiwrPXG9-g
 * Youtube link - https://youtu.be/NA8B84DZYSA
 *
 */
class NodeRef{
    Node node;
}

enum Color{
    RED,
    BLACK
}

public class BinaryTree {
    public Node addNode(int data, Node head){
        Node tempHead = head;
        Node n = Node.newNode(data);
        if(head == null){
            head = n;
            return head;
        }
        Node prev = null; //prev is Parent
        while(head != null){ //head  is current
            prev = head;
            if(head.data < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }

        //prev holding last parent node
        if(prev.data < data){
            prev.right = n;
        }else{
            prev.left = n;
        }

        return tempHead;
    }
    
    class IntegerRef{
        int height;
    }
    
    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(-1, head);
        head = bt.addNode(21, head);
        System.out.println(bt.height(head));
        
    }
}
