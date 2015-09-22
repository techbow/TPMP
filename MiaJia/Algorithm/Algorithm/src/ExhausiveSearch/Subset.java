package ExhausiveSearch;
import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
	public static ArrayList<ArrayList<Integer>> subset(int[] num){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if(num.length == 0 || num == null){
			return res;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
//		int pos = 0;
		helper(res, list, 0, num);
		return res;
	}
	private static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int pos,int[] num){
		res.add(new ArrayList<Integer> (list));
		for(int i = pos; i < num.length; i++){
			list.add(num[i]);
			helper(res,list,i+1,num);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {

		int[] a = {1, 2, 3};
		System.out.println(subset(a));

	}
}