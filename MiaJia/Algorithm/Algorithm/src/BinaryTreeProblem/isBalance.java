package BinaryTreeProblem;



/**
 * 根据题意，平衡树的定义是两子树的深度差最大不超过1，显然使用递归进行分析较为方便。
 * 既然使用递归，那么接下来就需要分析递归调用的终止条件。和之前的 Maximum Depth 
 * of Binary Tree | Algorithm 类似，NULL == root必然是其中一个终止条件，返回0；
 * 根据题意还需的另一终止条件应为「左右子树高度差大于1」，但对应此终止条件的返回值是多少？
 * ——INT_MAX or INT_MIN？想想都不合适，为何不在传入参数中传入bool指针或者bool引
 * 用咧？并以此变量作为最终返回值
 * 
 * 首先可以确定abs(leftDepth - rightDepth) > 1肯定是需要特殊处理的，如果返回-1呢？
 * 咋一看似乎在下一步返回max(leftDepth, rightDepth) + 1时会出错，再进一步想想，我
 * 们能否不让max...这一句执行呢？如果返回了-1，其接盘侠必然是leftDepth或者rightDepth
 * 中的一个，因此我们只需要在判断子树高度差大于1的同时也判断下左右子树深度是否为-1即可都
 * 返回-1
 */
public class isBalance {
	
	public static boolean isBalanced(TreeNode root) {
		return maxDepth(root) != -1;
	}

	private static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(0);  	  
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        root.left.left = new TreeNode (4);
        root.left.right = new TreeNode (5);
        root.left.right.right = new TreeNode (8);
        root.left.right.left = new TreeNode (7);

		System.out.println(isBalanced(root));


	}
	

}

