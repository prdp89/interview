//package com.interview.linklist;
//
//
//public class NthElementLinkList {
//
//	public class LLNode
//	{
//		public LLNode child;
//		public int data;
//
//		LLNode(int data,  LLNode node)
//		{
//			this.child = node;
//			this.data = data;
//		}
//	}
//
//    public static void main(String[] args) {
//
//    	LLNode current = new LLNode(1, null);
//        for (int i = 2; i < 8; i++) {
//            current = new LLNode(i, current);
//        }
//
//        LLNode head = current;
//        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
//
//        nthFromLast(head, 1); //should return 1.
//
//        System.out.println(linkedListToString(head));
//    }
//
//
//    // Implement your function below.
//    public static LLNode nthFromLast(LLNode head, int n) {
//    	LLNode left = head;
//    	LLNode right = head;
//
//        // First, make sure that we have at least n items in the linked list.
//        for (int i = 0; i < n; i++) {
//            if (right == null) return null;
//            right = right.child;
//        }
//        while (right != null) {
//            right = right.child;
//            left = left.child;
//        }
//        return left;
//    }
//
//
//    //  NOTE: Feel free to use the following function for testing.
//    //  It converts the given linked list into an easy-to-read string format.
//    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
//    public static String linkedListToString(LLNode head) {
//    	LLNode current = head;
//        StringBuilder sb = new StringBuilder();
//        while (current != null) {
//            sb.append(String.valueOf(current.data));
//            sb.append(" -> ");
//            current = current.child;
//        }
//        sb.append("(null)");
//        return sb.toString();
//    }
//}
