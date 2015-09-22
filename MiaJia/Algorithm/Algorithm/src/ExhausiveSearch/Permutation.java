package ExhausiveSearch;

import java.util.ArrayList;


public class Permutation {
//    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
//         ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
//         if (num == null || num.length == 0) {
//             return rst; 
//         }
//
//         ArrayList<Integer> list = new ArrayList<Integer>();
//         helper(rst, list, num);
//         return rst;
//    }
//    
//    public static void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num){
//        if(list.size() == num.length) {
//            rst.add(new ArrayList<Integer>(list));
//            return;
//        }
//        
//        for(int i = 0; i<num.length; i++){
//            if(list.contains(num[i])){
//                continue;
//            }
//            list.add(num[i]);
//            helper(rst, list, num);
//            list.remove(list.size() - 1);
//        }
//        
//    }
    public static ArrayList<ArrayList<Integer>> permute1(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return rst; 
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        helper1(rst, list, used, num);
        return rst;
   }
   
   public static void helper1(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list,boolean[] used, int[] num){
       if(list.size() == num.length) {
           rst.add(new ArrayList<Integer>(list));
           return;
       }
       
       for(int i = 0; i<num.length; i++){
//           if(used[i]==true){
//               continue;
//           }
    	   if(!used[i]){
           list.add(num[i]);
           used[i] = true;
           helper1(rst, list, used, num);
           list.remove(list.size() - 1);
           used[i] = false;
    	   }
       }
       
   }
    public static void main(String[] args) {

    	int[] a = {1, 2, 3};
//		System.out.println(permute(a));
		System.out.println(permute1(a));
		
    }
}
