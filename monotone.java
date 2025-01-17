class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0;
        int cntone = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '1'){
                cntone++;
            }
            else{
                res = Math.min(res + 1, cntone);
            }
        }
        return res;
    }
}