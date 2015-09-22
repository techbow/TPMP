package BinaryTreeProblem;

import java.util.ArrayList;

import BinarySearchProblem.TreeNode;

public class lowestCommonAncestor {
	/*
	 * 法一：当有Treenode.parent时
	 */
	//    private ArrayList<TreeNode> getPath2Root(TreeNode node) {
	//        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	//        while (node != null) {
	//            list.add(node);
	//            node = node.parent;
	//        }
	//        return list;
	//    }
	//    public TreeNode LCA(TreeNode node1, TreeNode node2) {
	//        ArrayList<TreeNode> list1 = getPath2Root(node1);
	//        ArrayList<TreeNode> list2 = getPath2Root(node2);
	//        
	//        int i, j;
	//        for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
	//            if (list1.get(i) != list2.get(j)) {
	//                return list1.get(i).parent;
	//            }
	//        }
	//        return list1.get(i+1);
	//    }
	/*
	 * 1 Both nodes are to the left of the tree.
	 * 2 Both nodes are to the right of the tree.
	 * 3 One node is on the left while the other is on the right.
	 * 4 When the current node equals to either of the two nodes, this node must be the LCA too.
	 */
	
	  //结合例子和递归的整体思想去理解代码，在root == A || root == B后即层层
    //上浮(自底向上)，直至找到最终的最小公共祖先节点。


	public static TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}

		// Divide
		TreeNode left = LCA(root.left, A, B);
		TreeNode right = LCA(root.right, A, B);

		// Conquer
		if (left != null && right != null) {
			return root;
		} 
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}
	public static void main(String[] args) {
		/* 
            1  
           / \  
          2   3  
         / \   \  
        4   5   6      
		 */  
			TreeNode r1 = new TreeNode(1);
			TreeNode r2 = new TreeNode(2);
			TreeNode r3 = new TreeNode(3);
			TreeNode r4 = new TreeNode(4);
			TreeNode r5 = new TreeNode(5);
			TreeNode r6 = new TreeNode(6);
			TreeNode r7 = new TreeNode(0);

			r1.left = r2;
			r1.right = r3;
			r2.left = r4;
			r2.right = r5;
			r3.right = r6;
			r4.left = r7;
			//	    	  TreeNode root = new TreeNode(0);
			//	    	  
			//	          root.left = new TreeNode (2);
			//	          TreeNode node1 = new TreeNode (9);
			//	          root.right = node1;
			//	          TreeNode node2 = new TreeNode (4);
			//	          node2 = root.left.left;
			//	          root.left.right = new TreeNode (5);
			//	          root.left.right.right = new TreeNode (8);
			//	          root.left.right.left = new TreeNode (7);

			System.out.println(LCA(r1,r3,r6).val);
		}
	}