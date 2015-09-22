package ExhausiveSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0)
			return result;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] visited = new int[num.length];

		Arrays.sort(num);
		helper(result, list, visited, num);
		return result;
	}

	public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num) {
		if(list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for(int i = 0; i < num.length; i++) {
			if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
				/*在遇到当前元素和前一个元素相等时，如果前一个元素visited[i - 1] == false,
	                那么我们就跳过当前元素并进入下一次循环，这就是剪枝的关键所在。另一点需要
	                特别注意的是这种剪枝的方法能使用的前提是提供的nums是有序数组，否则无效。
				 */
				/*
				上面这一连串判断条件，重点在于要能理解!visited.contains(i-1)
				要理解这个，首先要明白i作为数组内的序号，i是唯一的
				给出一个排好序的数组，[1,2,2]
				第一层递归			第二层递归			第三层递归
				[1]					[1,2]				[1,2,2]
			        序号:[0]				 [0,1]			[0,1,2]
				这种都是OK的，但当第二层递归i扫到的是第二个"2"，情况就不一样了
				[1]					[1,2]				[1,2,2]			
	                         序号:[0]				[0,2]				[0,2,1]
				所以这边判断的时候!visited.contains(0)就变成了true，不会再继续递归下去，跳出循环
				步主要就是为了去除连续重复存在的，很神奇反正 = =||
				 */
				continue;
			}
			visited[i] = 1;
			list.add(num[i]);
			helper(result, list, visited, num);
			list.remove(list.size() - 1);
			visited[i] = 0;
		}
	}    
}

