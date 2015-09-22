package BinaryTreeProblem;

import java.util.LinkedList;
import java.util.Queue;

public class BFStemplate {
	/*
	 * BFS 三种实现方法
	 * 1, 2 queue 
	 * 两个队列互相倒过来倒过去
	 * 
	 * 2, 1 queue + dummy node
	 * Dummy Node(任意定义一个符号，eg:'#')
	 * 每两层的中间表示上一层遍历完了
	 * 
	 * 3, 1 queue(best)
	 * Java中Queue是一个虚类，不能直接new要告诉如何实现；比如
	 * 	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	 * Queue<TreeNode> queue = new ArrayList<TreeNode>();
	 * 这两个的区别
	 */
	Queue<TreeNode> queue1 = new Queue<TreeNode>();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();

}
