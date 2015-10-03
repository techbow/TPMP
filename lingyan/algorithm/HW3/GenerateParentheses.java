public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return null;
        }
        List<String> result= new ArrayList<String>();
        StringBuilder combParentheses = new StringBuilder();
        int start = 0;
        dfs(n, start, combParentheses, result);
        return result;
    }
    
    public void dfs(int n, int start, StringBuilder combParentheses, List<String> result){
        if(combParentheses.length() == (n * 2)){
            result.add(combParentheses.toString());
            return;
        }
        System.out.println(combParentheses.length());
        for(int i = start; i <= combParentheses.length(); i++){
            combParentheses.insert(i, "()");
            dfs(n, i + 1, combParentheses, result);
            combParentheses.deleteCharAt(i + 1); 
            combParentheses.deleteCharAt(i); 
            
        }
    }
}