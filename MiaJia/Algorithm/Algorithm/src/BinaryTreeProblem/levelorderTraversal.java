package BinaryTreeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelorderTraversal {
	  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//	        ArrayList result = new ArrayList();

	        if (root == null){
	            return result;
	        }
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.offer(root);
	        
	        while (!q.isEmpty()){
	            ArrayList<Integer> level = new ArrayList<Integer>();
	            int size = q.size();
	            for( int i = 0; i < size; i ++){
	                TreeNode head = q.poll();
	                level.add(head.val);
	                if (head.left != null){
	                    q.offer(head.left);
	                }
	                if (head.right != null){
	                    q.offer(head.right);
	                }
	            }
	            result.add(level);
	        }
	        return result;
	        
	    }
}
