package BinaryTreeProblem;

import BinarySearchProblem.TreeNode;

/**
 * @param root: The root of the binary search tree.
 * @param node: insert this node into the binary search tree
 * @return: The root of the new binary search tree.
 */
/*
 * 二叉树的题使用递归自然是最好理解的，代码也简洁易懂，
 * 缺点就是递归调用时栈空间容易溢出，故实际实现中一般使用迭代替代递归，性能更佳嘛。
 * 不过迭代的缺点就是代码量稍(很)大，逻辑也可能不是那么好懂。
 */
/*法一：使用递归，考虑如下两点：
 * 1 基本条件/终止条件 - 返回值需斟酌。
 * 2 递归步/条件递归 - 能使原始问题收敛。
 * 
 * 首先来找找递归步，根据二叉查找树的定义，若插入节点的值若大于当前节点的值，
 * 则继续与当前节点的右子树的值进行比较；反之则继续与当前节点的左子树的值进
 * 行比较。题目的要求是返回最终二叉搜索树的根节点，从以上递归步的描述中似乎
 * 还难以对应到实际代码，这时不妨分析下终止条件。
 * 有了递归步，终止条件也就水到渠成了，若当前节点为空时，即返回结果。
 * 问题是——返回什么结果？当前节点为空时，说明应该将「插入节点」插入到上一个遍历节点
 * 的左子节点或右子节点。对应到程序代码中即为root->right = node或者
 * root->left = node. 也就是说递归步使用root->right/left = func(...)即可。
 */

public class InsertNodeinBST {
//	public static TreeNode insertNode(TreeNode root, TreeNode node) {
//	if (root == null) return node;
//	if (node == null) return root;
//		if ( node.val >= root.val ){
//			insertNode(root.right, node);
//		}
//		if ( node.val < root.val ){
//			insertNode(root.left, node);
//		}
//		return node;
//
//	}
public TreeNode insertNode2(TreeNode root, TreeNode node) {
	if (root == null) return node;
	if (node == null) return root;

	TreeNode rootcopy = root;
	while (root != null) {
		if (root.val <= node.val && root.right == null) {
			root.right = node;
			break;
		}
		else if (root.val > node.val && root.left == null) {
			root.left = node;
			break;
		}
		else if(root.val <= node.val) root = root.right;
		else root = root.left;
	}
	return rootcopy;
}
public static void main(String[] args) {
	/* 
            1  
           / \  
          2   3  
         / \   \  
        4   5   9     
	 */  
	TreeNode r1 = new TreeNode(1);
	TreeNode r2 = new TreeNode(2);
	TreeNode r3 = new TreeNode(3);
	TreeNode r4 = new TreeNode(4);
	TreeNode r5 = new TreeNode(5);

	TreeNode r6 = new TreeNode(9);

	TreeNode node = new TreeNode(6);

	r1.left = r2;
	r1.right = r3;
	r2.left = r4;
	r2.right = r5;
	r3.right = r6;
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

	System.out.println(insertNode(r1,node).val);

}
}
