public class Solution {
    public int totalNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int count = 0;
        helper(n,0,new int[n], res);
        return res.size();
        
    }
    
    private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res){
        if(row == n){
            String[] item = new String[n];
            for(int i=0;i<n;i++){
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(columnForRow[i]==j){
                        strRow.append('Q');
                    }else{
                        strRow.append('.');
                    }
                }
                item[i] = strRow.toString();
            }
            res.add(item);
            return;
        }
        for(int i=0;i<n;i++){
            columnForRow[row] = i;
            if(check(row,columnForRow)){
                helper(n,row+1,columnForRow,res);
            }
        }
    }
    private boolean check(int row, int[] columnForRow){
        for(int i=0;i<row;i++){
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i){
                return false;
            }
        }
        return true;
    }

}