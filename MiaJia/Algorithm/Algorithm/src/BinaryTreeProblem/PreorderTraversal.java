package BinaryTreeProblem;
import java.util.ArrayList;
import java.util.Stack;

  
 
public class PreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
	public class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	  }
	
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    //Method1 : TRAVERSE:面试时不推荐递归这种做法。
    //  递归版很好理解，首先判断当前节点(根节点)是否为null，是则返回空vector
    //  ，否则先返回当前节点的值，然后对当前节点的左节点递归，最后对当前节点
    //  的右节点递归。递归时对返回结果的处理方式不同可进一步细分为遍历和分治
    //  两种方法。
    // 时间复杂度 O(n)
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     traversal(root, result);
    //     return result;
    // }
    // private void traversal(TreeNode root, ArrayList<Integer> result){
    //     if(root == null){
    //         return;
    // }
    // result.add(root.val);
    // traversal(root.left, result);
    // traversal(root.right, result);
    // }
    
    //Method2 : NON_TRAVERSE:STACK!!!!
    //迭代时需要利用栈来保存遍历到的节点，纸上画图分析后发现应首先进行出栈抛出
    // 当前节点，保存当前节点的值，随后将右、左节点分别入栈(注意入栈顺序，先右后
    // 左)，迭代到其为叶子节点(NULL)为止。
    //
    // 1 对root进行异常处理
    // 2 将root压入栈
    // 3 循环终止条件为栈s为空，所有元素均已处理完;初次进栈时S为空，root != null
    // 4 若当前根节点为空，首先取出栈顶元素为根节点；若不空，直接加入result
    // 5 若右节点不为空压入栈内。
    // 6 root向下iterative到左节点
    // 7 返回最终结果
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    if(root == null)         return result;
    Stack<TreeNode> s = new Stack<TreeNode>();
     while(!s.isEmpty() || root != null){
         if ( root == null){
             root = s.pop();
         }
         result.add(root.val);
         if (root.right != null){
                s.push(root.right); 
            }
         root = root.left;
     }
       return result;
    // while(!s.isEmpty()){
    //  TreeNode node = s.pop();
    //  result.add(node.val);
    //  //记住stack是先pop栈顶，所以先加right
    //  if (node.right != null) s.push(node.right); 
    //  if (node.left != null) s.push(node.left); 
    // }
  
  
    //Method3 : DIVIDE and CONQUER
    //  ArrayList<Integer> result = new ArrayList<Integer>();
    //  if(root == null){
    //         return result;
    //  }
    // //divide
    // ArrayList<Integer> left = preorderTraversal(root.left);
    // ArrayList<Integer> right =  preorderTraversal(root.right);
    
    // //conquer
    // result.add(root.val);
    // result.addAll(left);
    // result.addAll(right);
    // return result;
    }
}
