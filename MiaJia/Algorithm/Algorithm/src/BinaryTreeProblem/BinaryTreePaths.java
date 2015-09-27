package BinaryTreeProblem;

import java.util.ArrayList;
import java.util.List;

import Basic.Tree.TreeNode;



public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<String>();
    	if (null == root) { return res;}
    	BTPhelper(res, new StringBuilder(), root);
		return res;    	
    }
    private void BTPhelper(List<String> res, StringBuilder s, TreeNode root){
    	if(root.left == null && root.right == null){
    		s.append(root.val);
    		res.add(s.toString());
    		return;
    	}
    	if( root.left != null){
    		BTPhelper(res, new StringBuilder(s).append(root.val).append("->"), root.left);
    	}
    	if( root.right != null){
    		BTPhelper(res, new StringBuilder(s).append(root.val).append("->"), root.right);
    	}
    }
    
    public List<String> binaryTreePathsI(TreeNode root) {
    	List<String> res = new ArrayList<String>();
    	if (null == root) { return res;}
    	BTPhelperI(res, String.valueOf(root.val), root);
		return res;    	
    }
    private void BTPhelperI(List<String> res, String s, TreeNode root){
    	if(root.left == null && root.right == null){
    		res.add(s);
    		return;
    	}
    	if( root.left != null){
    	    BTPhelperI(res, s + "->" + root.left.val, root.left);
    	}
    	if( root.right != null){
    	    BTPhelperI(res, s + "->" + root.right.val, root.right);
    	}
    }

}
