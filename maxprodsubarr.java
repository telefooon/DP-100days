public class maxprodsubarr {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currmin = 1;
        int currmax = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                currmin = 1;
                currmax = 1;
            }
            int tmp = currmax * nums[i];
            currmax = Math.max(currmax * nums[i], Math.max(currmin * nums[i], nums[i]));
            currmin = Math.min(tmp, Math.min(currmin * nums[i], nums[i]));

            res = Math.max(res, currmax);
        }
        return res;
    }
}
