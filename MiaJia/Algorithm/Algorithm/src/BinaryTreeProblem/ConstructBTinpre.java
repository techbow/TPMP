package BinaryTreeProblem;

public class ConstructBTinpre {
	  //范围什么的比较易错 以左右子树的长度来说最为保险
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if( preorder == null || inorder ==null || preorder.length != inorder.length){
    		return null;
    	}
    	return myTreeBuilder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

	private TreeNode myTreeBuilder(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
		if(pStart > pEnd || iStart > iEnd){
			return null;
		}
		TreeNode root = new TreeNode(preorder[pStart]);
		int rIndex = getIndex(inorder, iStart, iEnd, preorder[pStart]);
		if(rIndex==-1) return null;

		
		root.left = myTreeBuilder(preorder, pStart + 1, rIndex + pStart - iStart , inorder,iStart ,rIndex - 1);
		root.right = myTreeBuilder(preorder,pEnd - iEnd + rIndex +1 ,pEnd , inorder,rIndex + 1, iEnd);
    	return root;
    }
    int getIndex( int[] inorder, int start, int end, int val){
    	for( int i = start; i <= end; i++){
    		if(inorder[i] == val){
    			return i;
    		}
    	}
    	return -1;
    }
    
}
