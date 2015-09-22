package BinaryTreeProblem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class PostorderTraversal {
	/**
	 * @param root: The root of binary tree.
	 * @return: Postorder in ArrayList which contains node values.
	 */
	public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		//Method1 : TRAVERSE
		//     ArrayList<Integer> result = new ArrayList<Integer>();
		//     traversal(root, result);
		//     return result;
		// }
		// private void traversal(TreeNode root, ArrayList<Integer> result){
		//     if(root == null){
		//         return;
		// }

		// traversal(root.left, result);
		// traversal(root.right, result);
		// result.add(root.val);
		// }
		//Method2 : NON_TRAVERSE:STACK!!!!
		//就是把preorder的入栈顺序反一下 然后反向输出Collections.reverse(result);
		//也可以用一样的顺序，不过插入result时一直插在最先的位置

		ArrayList<Integer> result = new ArrayList<Integer>();
		//记住写error check！！
		if(root == null)    return result;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		while(!s.isEmpty()){
			TreeNode node = s.pop();
			result.add(node.val);
			if (node.left != null) s.push(node.left); 
			if (node.right != null) s.push(node.right); 
		}
		Collections.reverse(result);
		return result;

	}

	//Method3 : DIVIDE and CONQUER
	//  ArrayList<Integer> result = new ArrayList<Integer>();
	//  if(root == null){
	//         return result;
	//  }
	// //divide
	// ArrayList<Integer> left = postorderTraversal(root.left);
	// ArrayList<Integer> right =  postorderTraversal(root.right);

	// //conquer
	// result.addAll(left);
	// result.addAll(right);
	// result.add(root.val);
	// return result;
	// }
}
