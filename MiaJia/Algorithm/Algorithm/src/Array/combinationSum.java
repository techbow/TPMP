package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/*比如{2, 3, 6, 7}，x = 7，组合就是{2, 2, 3}和{7}。
 *不能有重复，且必须是sorted order。
 *这个是标准DFS，一定要记住。
 *1 先sort array，
 *2 然后试图用2(当前元素），用了2之后x相当于只剩5，然后下一层递归再用2，用到没法再用为止（当前值比x还大） if (arr[i] > target) 。
 *3 失败后stack pop出来，再试着在前面用了2, 2, 2的条件下用3， 挂，pop出2，在22的条件下用3，正好，输出。
 *  然后再pop一个2，再用3， {2, 3}，再用下一个3。。在脑子里想一下和树的dfs的图是一样的。
*/
public class combinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		  Arrays.sort(candidates);
		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		  Stack<Integer> path = new Stack<Integer>();
		  combinationSum(candidates, target, 0, path, result);
		  return result;
		}
		
	private void combinationSum(int[] arr, int target, int start, Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
		  if (target == 0) {
		    ArrayList<Integer> list = new ArrayList<Integer>();
		    list.addAll(path);
		    result.add(list);
		    return;
		  }
		  for (int i = start; i < arr.length; i++) {
		    if (arr[i] > target) //这时候break可以保证不要再查后面那些越来越大的
		      return;
		    path.push(arr[i]);
		    combinationSum(arr, target - arr[i], i, path, result); //start永远不会越界，所以一开始不用check
		    path.pop();
		   }
		 }
}
